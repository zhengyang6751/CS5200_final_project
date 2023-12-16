package blog.model;


public class CharacterCurrency {
    private String firstName;
    private String lastName;
    private String currencyName;
    private int amountTotal;
    private int amountWeek;
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
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public int getAmountTotal() {
		return amountTotal;
	}
	public void setAmountTotal(int amountTotal) {
		this.amountTotal = amountTotal;
	}
	public int getAmountWeek() {
		return amountWeek;
	}
	public void setAmountWeek(int amountWeek) {
		this.amountWeek = amountWeek;
	}
	public CharacterCurrency(String firstName, String lastName, String currencyName, int amountTotal, int amountWeek) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.currencyName = currencyName;
		this.amountTotal = amountTotal;
		this.amountWeek = amountWeek;
	}
	@Override
	public String toString() {
		return "CharacterCurrency [firstName=" + firstName + ", lastName=" + lastName + ", currencyName=" + currencyName
				+ ", amountTotal=" + amountTotal + ", amountWeek=" + amountWeek + "]";
	}
	
    // Constructors, getters, and setters
    
    // Additional methods as needed
}
