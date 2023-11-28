package blog.model;

public class InventoryItem{
    String firstName;
    String lastName;
    String itemName;
    int number;
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
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName= itemName;
    }
    public InventoryItem(String firstName, String lastName, String itemName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.itemName = itemName;
        this.number = number;
    }
    @Override
    public String toString() {
        return "InventoryItem [firstName=" + firstName + ", lastName=" + lastName + ", itemName=" + itemName
                + ", number=" + number + "]";
    }
    
}
