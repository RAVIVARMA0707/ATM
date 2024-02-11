package edu.bit.atm.mine;

import java.util.Scanner;

public class Ui {
	private static Integer accountNumber = null;
	private static Integer pin = null;
	private static Integer amount = null;
	private static Scanner scan = new Scanner(System.in);
	private static Pin obj = new Pin();

	public static void main(String[] a) {
		pinValidation();
//		bankingServices();
	}

	private static void pinValidation() {
		Integer attempts = 3;
		while (attempts > 0) {
			System.out.println("Enter your account number");
			getAccNum();
			if (accountNumber.equals(obj.getAccountNum())) {
				for (Integer i = 1; i <= 4; i++) {
					System.out.println("Enter your Pin number");
					getpin();
					if (pin.equals(obj.getPin())) {
						i = 4;
						bankingServices();
					} else {
						if (i == 3) {
							System.out.println("You have reached the limit and account have been locked");
							System.exit(0);
						}
						System.out.println("You entered wrong pin Try again\nOnlyOnly"+ (3 - i) + "Atempts Left");
					}
				}
			} else {
				--attempts;
				if (attempts == 0) {
					System.out.println("You have reached the limit and account have been locked");
					System.exit(0);
				}
				System.out.println("You entered wrong account number\nOnly"+ attempts + "Atempts Left");
			}
		}

	}

	private static void getAccNum() {
		accountNumber = scan.nextInt();

	}

	private static void getpin() {
		pin = scan.nextInt();
	}

	private static Integer bankingServicesUi() {
		System.out.println("Enter Service To Do\n1.WithDrawl\n2.Deposit\n3.Balance Enquiry\n4.Exit");
		Integer num = scan.nextInt();
		return num;
	}

	private static void bankingServices() {
		Integer serviceNumber = bankingServicesUi();
		switch (serviceNumber) {
		case 1 : withdrwal();

		case 2 : deposit();
			
		case 3 :balanceEnquiry();
//			
		case 4 : System.exit(0);

		default :
			System.out.println("Enter an wrong service\nEnter Again");
			bankingServicesUi();
		
		}

	}

	private static void withdrwal() {
		Integer balance = obj.getBalance();	
		System.out.println("You can Withdraw \nYour Balance is " + balance + "\nEnter an amount to Withdraw in multiples of 100: ");
		amount = scan.nextInt();
		if ((amount <= obj.getBalance())&&validateAmount()) {
			Integer balance1 = obj.getBalance() - amount;
			obj.setBalance(balance1);
			System.out.println("Your balance After Withdrawl is " + obj.getBalance()+"\nAmount Deduced\nThanks For Choosing US");
			System.exit(0);
		} else {
			if(amount <= obj.getBalance()) 
			{
			System.out.println("Insufficient Balance!!!!\nAmount Not Deduced\nTransaction Cancelled!!!");
			System.exit(0);
			}
			else {
				System.out.println("Entered wrong amount!\\nAmount Not Deduced\nTransaction Cancelled!!!");
				withdrwal();
			}
			
		}
	}
	
	private static boolean validateAmount() {
		return (amount%100==0)?true:false;
	}
	
	private static void deposit() {
		System.out.println("You can Deposit in Multiples of Hundred\nEnter an amount to Deposit : ");
		amount = scan.nextInt();
		if (amount >0&&validateAmount()) {
			Integer balance1 = obj.getBalance() + amount;
			obj.setBalance(balance1);
			System.out.println("Amount is Deposited\nYour balance After Deposit is " + obj.getBalance()+"\nThanks For Choosing US");			
			System.exit(0);
		} else {
			System.out.println("Entered An In-correct Amount\nAmount is Not Deposited\nTransaction Cancelled!!!");
			System.exit(0);
		}
	}
	
	private static void balanceEnquiry() {
		System.out.println("Your balance is " + obj.getBalance()+"\nThanks For Choosing US");
	}

}
