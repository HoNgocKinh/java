package aop.account;

public class Account {
	
	private String owner;
    private String currency;
    private int balance;
    
	public Account() {
		super();
	}

	public Account(String owner, String currency, int balance) {
		super();
		this.owner = owner;
		this.currency = currency;
		this.balance = balance;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
    
    
}
