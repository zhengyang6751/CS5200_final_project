package blog.model;

public class EquippedItem {
    private String firstName;
    private String lastName;
    private String slotName;
    private String itemName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSlotName() {
        return slotName;
    }
    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public EquippedItem(String firstName, String lastName, String slotName, String itemName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.slotName = slotName;
        this.itemName = itemName;
    }
    @Override
    public String toString() {
        return "EquippedItem [firstName=" + firstName + ", lastName=" + lastName + ", slotName=" + slotName
                + ", itemName=" + itemName + "]";
    }
    
}
