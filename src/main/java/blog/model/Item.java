package blog.model;

public class Item {
    private String itemName;
    private int stackSize;
    private int vendorPrice;
    private boolean isSellable;

    // Constructors (default and parameterized)

    // Getters and setters

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public int getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(int vendorPrice) {
        this.vendorPrice = vendorPrice;
    }

    public boolean isSellable() {
        return isSellable;
    }

    @Override
    public String toString() {
        return "Item [itemName=" + itemName + ", stackSize=" + stackSize + ", vendorPrice=" + vendorPrice
                + ", isSellable=" + isSellable + "]";
    }

    public void setIsSellable(boolean sellable) {
        isSellable = sellable;
    }
    public boolean getIsSellable() {
        return isSellable;
    }

    public Item(String itemName, int stackSize, int vendorPrice, boolean isSellable) {
        this.itemName = itemName;
        this.stackSize = stackSize;
        this.vendorPrice = vendorPrice;
        this.isSellable = isSellable;
    }
    
    // Additional methods if needed
}

