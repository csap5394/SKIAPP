package model;

public class Payment {
	private String method;
	private double credit;
	
	public Payment(String method, double credit) {
		this.method = method;
		this.credit = credit;
	}
	
	public void transferMoney(double money) {
		//connect to bank, pay 
		this.credit = this.credit - money;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	
}
