package blog.model;

public class WeaponItem {
    private String itemName;
    private int itemLevel;
    private int requiredLevel;
    private String requiredJob;
    private boolean autoAttack;
    private int attackDelay;
    private int damageDone;

    // Constructors (default and parameterized)

    // Getters and setters

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

    public boolean getAutoAttack() {
        return autoAttack;
    }

    public void setAutoAttack(boolean autoAttack) {
        this.autoAttack = autoAttack;
    }

    public int getAttackDelay() {
        return attackDelay;
    }

    public void setAttackDelay(int attackDelay) {
        this.attackDelay = attackDelay;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(int damageDone) {
        this.damageDone = damageDone;
    }

    public WeaponItem(String itemName, int itemLevel, int requiredLevel, String requiredJob,
            boolean autoAttack, int attackDelay, int damageDone) {
        this.itemName = itemName;
        this.itemLevel = itemLevel;
        this.requiredLevel = requiredLevel;
        this.requiredJob = requiredJob;
        this.autoAttack = autoAttack;
        this.attackDelay = attackDelay;
        this.damageDone = damageDone;
    }

    @Override
    public String toString() {
        return "WeaponItem [itemName=" + itemName + ", itemLevel=" + itemLevel 
                + ", requiredLevel=" + requiredLevel + ", requiredJob=" + requiredJob + ", autoAttack=" + autoAttack
                + ", attackDelay=" + attackDelay + ", damageDone=" + damageDone + "]";
    }
    
    // Additional methods if needed
}

