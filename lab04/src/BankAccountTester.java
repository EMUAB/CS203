import java.util.Scanner;

public class BankAccountTester {

	public static void main(String[] args)
	{
		String firstname, lastname;
		int accNo;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first and last names followed by account number of customer");

		firstname = sc.nextLine();
		lastname = sc.nextLine();
		accNo = Integer.parseInt(sc.nextLine());

		BankAccount b = new BankAccount(4500);
		b.setName(firstname,lastname);
		b.setAccNo(accNo);
		System.out.println("Your name is " + b.getName());
		System.out.println("Your current balance is $" + b.getBalance());
		b.setDeposit(2308);
		System.out.println("You have deposited $2308, making your current balance $" + b.getBalance());
		b.setWithdrawal(120);
		System.out.println("You have withdrawn $120, making your current balance $" + b.getBalance());
		b.setLoan();
		System.out.println("You have taken out a loan of $5000, making your current balance $" + b.getBalance());
		System.out.println("With a 5% p.a. over the course of 3 years, you will owe $" + b.getLoan());
		System.out.println("Your account number is an Armstrong number: " + b.isArmstrong());
	}

}
