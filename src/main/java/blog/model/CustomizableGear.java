package blog.model;

public class CustomizableGear {
    private String itemName;
    private int customizableGearId;
    private String dyeColor;
    private String quality;
    private String itemCondition;
    private String characterMadeTheItem;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getCustomizableGearId() {
        return customizableGearId;
    }
    public void setCustomizableGearId(int customizableGearId) {
        this.customizableGearId = customizableGearId;
    }
    public String getDyeColor() {
        return dyeColor;
    }
    public void setDyeColor(String dyeColor) {
        this.dyeColor = dyeColor;
    }
    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }
    public String getItemCondition() {
        return itemCondition;
    }
    public void setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
    }
    public String getCharacterMadeTheItem() {
        return characterMadeTheItem;
    }
    public void setCharacterMadeTheItem(String characterMadeTheItem) {
        this.characterMadeTheItem = characterMadeTheItem;
    }
    public CustomizableGear(String itemName, String dyeColor, String quality,
            String itemCondition, String characterMadeTheItem) {
        this.itemName = itemName;
        this.dyeColor = dyeColor;
        this.quality = quality;
        this.itemCondition = itemCondition;
        this.characterMadeTheItem = characterMadeTheItem;
    }
    @Override
    public String toString() {
        return "CustomizableGear [itemName=" + itemName + ", customizableGearId=" + customizableGearId + ", dyeColor="
                + dyeColor + ", quality=" + quality + ", itemCondition=" + itemCondition + ", characterMadeTheItem="
                + characterMadeTheItem + "]";
    }
    
    // Constructors (default and parameterized)

    // Getters and setters

    // Additional methods if needed
}

