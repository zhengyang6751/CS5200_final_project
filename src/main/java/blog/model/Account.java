package blog.model;

public class Account {
    private int accountId;
    private String name;
    private String emailAddress;
    private Currency currency;
    
	public Account(String name, String emailAddress) {
		this.name = name;
		this.emailAddress = emailAddress;
	}
	public Account(int accountId, String name, String emailAddress) {
		this.accountId = accountId;
		this.name = name;
		this.emailAddress = emailAddress;
	}
	public Account() {
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", emailAddress=" + emailAddress + "]";
	}
	
}

