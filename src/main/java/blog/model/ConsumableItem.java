package blog.model;

public class ConsumableItem {
    private String itemName;
    private int itemLevel;
    private String description;
    private int strengthBonusMax;
    private int dexterityBonusMax;
    private int vitalityBonusMax;
    private int intelligenceBonusMax;
    private int mindBonusMax;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemLevel() {
        return itemLevel;
    }
    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getStrengthBonusMax() {
        return strengthBonusMax;
    }
    public void setStrengthBonusMax(int strengthBonusMax) {
        this.strengthBonusMax = strengthBonusMax;
    }
    public int getDexterityBonusMax() {
        return dexterityBonusMax;
    }
    public void setDexterityBonusMax(int dexterityBonusMax) {
        this.dexterityBonusMax = dexterityBonusMax;
    }
    public int getVitalityBonusMax() {
        return vitalityBonusMax;
    }
    public void setVitalityBonusMax(int vitalityBonusMax) {
        this.vitalityBonusMax = vitalityBonusMax;
    }
    public int getIntelligenceBonusMax() {
        return intelligenceBonusMax;
    }
    public void setIntelligenceBonusMax(int intelligenceBonusMax) {
        this.intelligenceBonusMax = intelligenceBonusMax;
    }
    public int getMindBonusMax() {
        return mindBonusMax;
    }
    public void setMindBonusMax(int mindBonusMax) {
        this.mindBonusMax = mindBonusMax;
    }
    public ConsumableItem(String itemName, int itemLevel, String description, int strengthBonusMax,
            int dexterityBonusMax, int vitalityBonusMax, int intelligenceBonusMax, int mindBonusMax) {
        this.itemName = itemName;
        this.itemLevel = itemLevel;
        this.description = description;
        this.strengthBonusMax = strengthBonusMax;
        this.dexterityBonusMax = dexterityBonusMax;
        this.vitalityBonusMax = vitalityBonusMax;
        this.intelligenceBonusMax = intelligenceBonusMax;
        this.mindBonusMax = mindBonusMax;
    }
    @Override
    public String toString() {
        return "ConsumableItem [itemName=" + itemName + ", itemLevel=" + itemLevel + ", description=" + description
                + ", strengthBonusMax=" + strengthBonusMax + ", dexterityBonusMax=" + dexterityBonusMax
                + ", vitalityBonusMax=" + vitalityBonusMax + ", intelligenceBonusMax=" + intelligenceBonusMax
                + ", mindBonusMax=" + mindBonusMax + "]";
    }
    
    // Constructors (default and parameterized)

    // Getters and setters

    // Additional methods if needed
}

