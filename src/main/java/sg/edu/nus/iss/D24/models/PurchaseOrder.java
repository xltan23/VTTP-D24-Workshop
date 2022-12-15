package sg.edu.nus.iss.D24.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

// Comprise of list of LineItems to be purchased
public class PurchaseOrder {
    
    // Defining members of purchase order
    // General order ID, order name and order date and list of line items
    private String orderId;
    private String name;
    private Date orderDate;
    private List<LineItem> lineItems = new LinkedList<>();

    // Generate getter and setter
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    // Adding line item into Purchase Order list
    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }
}
