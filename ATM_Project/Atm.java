package practice;


import java.util.ResourceBundle;
import java.util.Scanner;


public class Atm {
	public static void main(String[]args) {
		
		int balance=10000,withdraw,deposit;
		
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.err.println("Vijay Mallaya Trusted Bank");
			System.out.println("1. For Withdraw");
			System.out.println("2. For Deposit");
			System.out.println("3. For Check Balance");
			System.out.println("4. To Exit");
			System.out.println(" Choose the operation which you want to perform");
			
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1:
				System.out.println("Enter money to be Withdrawn");
				
				withdraw=sc.nextInt();
				
				if(balance>=withdraw) {
					balance=balance-withdraw;
					System.out.println("Please collect your Money");
					
				}else {
					System.out.println("Insufficient Balance");
				}System.out.println("");
				break;
				
			case 2:
				System.out.println("Enter Money to be deposited");
				deposit=sc.nextInt();
				balance=balance+deposit;
				System.out.println("Your Money has been successfully depsited");
				System.out.println("");
				break;
				
			case 3:
				System.out.println("Balance:"+balance);
				System.out.println("");
				break;
				
			case 4:
				 return ;
			}
			sc.close();
				
				
		}
				
	}

}
