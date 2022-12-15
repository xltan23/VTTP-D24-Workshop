package sg.edu.nus.iss.D24.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.D24.models.PurchaseOrder;

import static sg.edu.nus.iss.D24.repositories.Queries.*;

@Repository
public class PurchaseOrderRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method completes the insertion and checks if the insertion is complete 
    public boolean insertPurchaseOrder(PurchaseOrder po) {
        // Query inputs order ID and name into purchase_order table (order date auto-generated)
        return jdbcTemplate.update(SQL_INSERT_PURCHASE_ORDER, po.getOrderId(), po.getName()) > 0;
    }
}
