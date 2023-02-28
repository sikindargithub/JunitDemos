package com.acheron.bank;

import com.acheron.exceptions.NegValueException;
import com.acheron.exceptions.ValueExceededException;

public class Bank {
	double balance;

	public Bank(double balance) {
		super();
		this.balance = balance;
	}
	
	public double deposit(int amount) throws NegValueException, ValueExceededException {
		if(amount<0)
			throw new NegValueException("Depositing amount would not be less than 0");
		if(amount>25000)
			throw new ValueExceededException("Depositing amount would not be greater than 25000");
		return balance+amount;
	}
	
	public double withDraw(int amount) throws NegValueException, ValueExceededException {
		if(amount<0)
			throw new NegValueException("Withdrawing amount would not be less than 0");
		if(amount<5000)
			throw new ValueExceededException("Withdrawing amount would not be less than 5000");
		if(amount>balance)
			throw new ValueExceededException("Withdrawing amount  should not be greater than balance");
		return balance-amount;
	}

}

