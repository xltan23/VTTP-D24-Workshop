package sg.edu.nus.iss.D24.models;

public class LineItem {
    
    // Defining members of Line Item
    private Integer itemId;
    private String description;
    private Integer quantity;

    // Constructors of LineItem
    public LineItem() {
    }
    public LineItem(String description, Integer quantity) {
        this.description = description;
        this.quantity = quantity;
    }

    // Generate getter and setter
    public Integer getItemId() {
        return itemId;
    }
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
