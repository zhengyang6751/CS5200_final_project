package blog.model;


public class Character {
    private int accountId;
    private String firstName;
    private String lastName;
    private int strength;
    private int dexterity;
    private int vitality;
    private int intelligence;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
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
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getVitality() {
		return vitality;
	}
	public void setVitality(int vitality) {
		this.vitality = vitality;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public Character(int accountId, String firstName, String lastName, int strength, int dexterity, int vitality,
			int intelligence) {
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.strength = strength;
		this.dexterity = dexterity;
		this.vitality = vitality;
		this.intelligence = intelligence;
	}
	@Override
	public String toString() {
		return "Character [accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", strength=" + strength + ", dexterity=" + dexterity + ", vitality=" + vitality + ", intelligence="
				+ intelligence + "]";
	}
	
    
}
