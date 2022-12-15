package sg.edu.nus.iss.D24.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.D24.exceptions.OrderException;
import sg.edu.nus.iss.D24.models.PurchaseOrder;
import sg.edu.nus.iss.D24.repositories.LineItemRepository;
import sg.edu.nus.iss.D24.repositories.PurchaseOrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private PurchaseOrderRepository poRepo;

    @Autowired
    private LineItemRepository liRepo;

    // Transactional because it is linking to 2 databases
    @Transactional(rollbackFor = OrderException.class)
    public void createNewOrder(PurchaseOrder po) throws OrderException {
        // Create a random ID for order
        String orderId = UUID.randomUUID().toString().substring(0,8);
        po.setOrderId(orderId);
        poRepo.insertPurchaseOrder(po);
        // Get the list of line items, if more than 5 line items in purchase order throw exception
        if (po.getLineItems().size() > 5) {
            throw new OrderException("Cannot order more than 5 items");
        }
        liRepo.addLineItems(po.getLineItems(), orderId);
    }
}
