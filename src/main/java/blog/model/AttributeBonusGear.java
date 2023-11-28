package blog.model;

public class AttributeBonusGear {
    private String itemName;
    private int strengthBonus;
    private int dexterityBonus;
    private int vitalityBonus;
    private int intelligenceBonus;
    private int mindBonus;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getStrengthBonus() {
        return strengthBonus;
    }
    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }
    public int getDexterityBonus() {
        return dexterityBonus;
    }
    public void setDexterityBonus(int dexterityBonus) {
        this.dexterityBonus = dexterityBonus;
    }
    public int getVitalityBonus() {
        return vitalityBonus;
    }
    public void setVitalityBonus(int vitalityBonus) {
        this.vitalityBonus = vitalityBonus;
    }
    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }
    public void setIntelligenceBonus(int intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }
    public int getMindBonus() {
        return mindBonus;
    }
    public void setMindBonus(int mindBonus) {
        this.mindBonus = mindBonus;
    }
    public AttributeBonusGear(String itemName, int strengthBonus, int dexterityBonus, int vitalityBonus,
            int intelligenceBonus, int mindBonus) {
        this.itemName = itemName;
        this.strengthBonus = strengthBonus;
        this.dexterityBonus = dexterityBonus;
        this.vitalityBonus = vitalityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.mindBonus = mindBonus;
    }
    @Override
    public String toString() {
        return "AttributeBonusGear [itemName=" + itemName + ", strengthBonus=" + strengthBonus + ", dexterityBonus="
                + dexterityBonus + ", vitalityBonus=" + vitalityBonus + ", intelligenceBonus=" + intelligenceBonus
                + ", mindBonus=" + mindBonus + "]";
    }
    
    // Constructors (default and parameterized)

    // Getters and setters

    // Additional methods if needed
}

