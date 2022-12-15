package sg.edu.nus.iss.D24.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.D24.exceptions.OrderException;
import sg.edu.nus.iss.D24.models.LineItem;
import sg.edu.nus.iss.D24.models.PurchaseOrder;

@Controller
@RequestMapping(path = "/cart")
public class CartController {
    
    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String,String> form, Model model, HttpSession sess) throws OrderException {
        // Retrieve all line items from the session
        List<LineItem> lineItems = (List<LineItem>) sess.getAttribute("cart");
        // If the cart is empty:
        if (null == lineItems) {
            System.out.println("This is a new session");
            System.out.printf("Session ID: %s\n", sess.getId());
            lineItems = new LinkedList<>();
            // Set session attribute: Assign empty list to the session name
            sess.setAttribute("cart", lineItems);
        }
        // Define item and add item to list (new or existing)
        String item = form.getFirst("item");
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        lineItems.add(new LineItem(item, quantity));
        // Create purchase order
        PurchaseOrder po = new PurchaseOrder();
        po.setName(form.getFirst("name"));
        for (LineItem lineItem : lineItems) {
            System.out.printf("Description: %s, Quantity: %s", lineItem.getDescription(), lineItem.getQuantity());
        }
        po.setLineItems(lineItems);
        sess.setAttribute("checkoutCart", po);
        model.addAttribute("lineItems", lineItems);
        return "main_cart";
    }


}
