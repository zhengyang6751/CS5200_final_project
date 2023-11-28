package blog.model;

public class GearItem {
    private String itemName;
    private int itemLevel;
    private String slotName;
    private int requiredLevel;
    private String requiredJob;
    private int defenseRating;
    private int magicDefenseRating;
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
    public String getSlotName() {
        return slotName;
    }
    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }
    public int getRequiredLevel() {
        return requiredLevel;
    }
    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
    public String getRequiredJob() {
        return requiredJob;
    }
    public void setRequiredJob(String requiredJob) {
        this.requiredJob = requiredJob;
    }
    public int getDefenseRating() {
        return defenseRating;
    }
    public void setDefenseRating(int defenseRating) {
        this.defenseRating = defenseRating;
    }
    public int getMagicDefenseRating() {
        return magicDefenseRating;
    }
    public void setMagicDefenseRating(int magicDefenseRating) {
        this.magicDefenseRating = magicDefenseRating;
    }
    public GearItem(String itemName, int itemLevel, String slotName, int requiredLevel, String requiredJob,
            int defenseRating, int magicDefenseRating) {
        this.itemName = itemName;
        this.itemLevel = itemLevel;
        this.slotName = slotName;
        this.requiredLevel = requiredLevel;
        this.requiredJob = requiredJob;
        this.defenseRating = defenseRating;
        this.magicDefenseRating = magicDefenseRating;
    }
    @Override
    public String toString() {
        return "GearItem [itemName=" + itemName + ", itemLevel=" + itemLevel + ", slotName=" + slotName
                + ", requiredLevel=" + requiredLevel + ", requiredJob=" + requiredJob + ", defenseRating="
                + defenseRating + ", magicDefenseRating=" + magicDefenseRating + "]";
    }
    
    // Constructors (default and parameterized)

    // Getters and setters

    // Additional methods if needed
}

