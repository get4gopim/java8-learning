package com.example.learning.java8;

public class SynchronizationDemo {

	public static void main(String[] args) {
		Account accountX = new Account(100, "XXX");
		Account accountY = new Account(1000, "YYY");
		
		createAndExecuteInThread(accountX, 500, TransactionType.WITHDRAW);
		
		createAndExecuteInThread(accountY, 400, TransactionType.WITHDRAW);
		
		createAndExecuteInThread(accountX, 800, TransactionType.DEPOSIT);
	}
	
	static void createAndExecuteInThread(Account acc, int amount, TransactionType type) {
		Runnable task = new Runnable() {			
			@Override
			public void run() {
				if (type == TransactionType.DEPOSIT) {
					acc.deposit(amount);
				} else if (type == TransactionType.WITHDRAW) {
					acc.withdraw(amount);
				}				
			}
		};
		
		Thread t1 = new Thread(task);
		t1.start();
	}
}

class Account {
	int amount;
	String name;

	Account(int amount, String name) {
		this.amount = amount;
		this.name = name;
	}

	public synchronized void deposit(int depositAmt) {
		System.out.printf("[%s]: Amount %d to be deposited to MyAccount (Balance: %d) \n", this.name, depositAmt, this.amount);
		this.amount += depositAmt;
		notify();
		
		System.out.printf("[%s]: Balance %d in MyAccount (dep) ... \n", this.name, this.amount);
	}

	public synchronized void withdraw(int withdrawAmt) {
		System.out.printf("[%s]: Amount %d to be withdrawn from MyAccount (Balance: %d) ... \n", this.name, withdrawAmt, this.amount);
		if (withdrawAmt > this.amount) {
			try {
				System.out.printf("[%s]: Balance %d. No found available. Waiting... \n", this.name, this.amount);
				wait(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (withdrawAmt <= this.amount) {
			this.amount -= withdrawAmt;
			System.out.printf("[%s]: Balance %d in MyAccount (withdraw) ... \n", this.name, this.amount);
		} else {
			System.out.printf("[%s]: Balance %d. No found available. \n", this.name, this.amount);			
		}		
	}
}

enum TransactionType {
	DEPOSIT, WITHDRAW;
}
