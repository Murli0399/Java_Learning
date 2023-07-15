package com.masai;

class EPFOAccount {
	private String accountNo;
	private int balance;

	public EPFOAccount(String accountNo, int balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account number: " + accountNo + " Balance: " + balance + "/-";
	}
}
