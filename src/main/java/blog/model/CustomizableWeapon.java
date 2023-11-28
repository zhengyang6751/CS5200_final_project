package blog.model;

public class CustomizableWeapon {
    private String itemName;
    private int customizableWeaponId;
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
    public int getCustomizableWeaponId() {
        return customizableWeaponId;
    }
    public void setCustomizableWeaponId(int customizableWeaponId) {
        this.customizableWeaponId = customizableWeaponId;
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
    public CustomizableWeapon(String itemName, int customizableWeaponId, String dyeColor, String quality,
            String itemCondition, String characterMadeTheItem) {
        this.itemName = itemName;
        this.customizableWeaponId = customizableWeaponId;
        this.dyeColor = dyeColor;
        this.quality = quality;
        this.itemCondition = itemCondition;
        this.characterMadeTheItem = characterMadeTheItem;
    }
    public CustomizableWeapon(String itemName, String dyeColor, String quality,
            String itemCondition, String characterMadeTheItem) {
        this.itemName = itemName;
        this.dyeColor = dyeColor;
        this.quality = quality;
        this.itemCondition = itemCondition;
        this.characterMadeTheItem = characterMadeTheItem;
    }
    @Override
    public String toString() {
        return "CustomizableWeapon [itemName=" + itemName + ", customizableWeaponId=" + customizableWeaponId
                + ", dyeColor=" + dyeColor + ", quality=" + quality + ", itemCondition=" + itemCondition
                + ", characterMadeTheItem=" + characterMadeTheItem + "]";
    }
    // Constructors (default and parameterized)

    // Getters and setters

    // Additional methods if needed
}

