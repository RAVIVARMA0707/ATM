package edu.bit.atm.mine;

public class Pin {
	private Integer accountNum =123456;
	private Integer pin=2003;
	private Integer balance=10000;
	
	public Integer getAccountNum() {
		return this.accountNum;
	}
	public Integer getPin() {
		return this.pin;
	}
	public Integer getBalance() {
		return this.balance;
	}
	
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	
}

