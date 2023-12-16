package blog.model;

public class Currency {
    private String currencyName;
    private int weeklyCaps;
    private int totalCaps;
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public int getWeeklyCaps() {
		return weeklyCaps;
	}
	public void setWeeklyCaps(int weeklyCaps) {
		this.weeklyCaps = weeklyCaps;
	}
	public int getTotalCaps() {
		return totalCaps;
	}
	public void setTotalCaps(int totalCaps) {
		this.totalCaps = totalCaps;
	}
	public Currency(String currencyName, int weeklyCaps, int totalCaps) {
		this.currencyName = currencyName;
		this.weeklyCaps = weeklyCaps;
		this.totalCaps = totalCaps;
	}
	@Override
	public String toString() {
		return "Currency [currencyName=" + currencyName + ", weeklyCaps=" + weeklyCaps + ", totalCaps=" + totalCaps
				+ "]";
	}
	
}
