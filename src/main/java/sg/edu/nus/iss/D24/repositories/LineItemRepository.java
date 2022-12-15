package sg.edu.nus.iss.D24.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.D24.models.LineItem;
import sg.edu.nus.iss.D24.models.PurchaseOrder;

import static sg.edu.nus.iss.D24.repositories.Queries.*;

@Repository
public class LineItemRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addLineItems(List<LineItem> lineItems, String orderId) {
        // List of object array
        List<Object[]> objectArrayList = lineItems.stream()
                                            .map(lineItem -> {
                                                // Each line item is the object array carrying its 3 members (Item ID is auto-increment)
                                                Object[] li = new Object[3];
                                                li[0] = lineItem.getDescription();
                                                li[1] = lineItem.getQuantity();
                                                li[2] = orderId;
                                                return li;
                                            }).toList();
        // Batch update issues multiple statement running down the objects in the list
        // objectArrayList comprise 3 components, MUST match number of ? in query (i.e. ?, ?, ?)
        jdbcTemplate.batchUpdate(SQL_INSERT_LINE_ITEM, objectArrayList);
    }

    public void addLineItems(PurchaseOrder po) {
        addLineItems(po.getLineItems(), po.getOrderId());
    }
}
