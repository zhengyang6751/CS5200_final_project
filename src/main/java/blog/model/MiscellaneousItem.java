package blog.model;

public class MiscellaneousItem {
    private String itemName;
    private String description;
    public MiscellaneousItem(String itemName, String description) {
        this.itemName = itemName;
        this.description = description;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "MiscellaneousItem [itemName=" + itemName + ", description=" + description + "]";
    }
    
    // Constructors (default and parameterized)

    // Getters and setters

    // Additional methods if needed
}

