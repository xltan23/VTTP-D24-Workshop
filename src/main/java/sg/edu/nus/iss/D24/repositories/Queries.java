package sg.edu.nus.iss.D24.repositories;

public class Queries {
    // Query to insert values into purchase_order fields
    public static String SQL_INSERT_PURCHASE_ORDER = "INSERT INTO purchase_order(order_id, name, order_date) values (?, ?, SYSDATE())";
    // Query to insert values into line_item fields
    public static String SQL_INSERT_LINE_ITEM = "INSERT INTO line_item(description, quantity, order_id) values (?, ?, ?)";
}
