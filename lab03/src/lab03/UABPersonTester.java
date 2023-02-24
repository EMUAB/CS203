package lab03;

public class UABPersonTester {
	public static void main(String args[]) {
		UABPerson person1 = new UABPerson("Barab", "male", 55, "bbrab");
		UABPerson person2 = new UABPerson("Rise", "female", 24, "perise");

		System.out.println(person1.getName() + " is a palindrome: " + person1.checkPalindrome());
		System.out.println(person1.getName() + " is " + person1.yearsUntilRetirement() + " years from retirement");
		System.out.println(person1.toString());

		System.out.println(person2.getName() + " is a palindrome: " + person2.checkPalindrome());
		System.out.println(person2.getName() + " is " + person2.yearsUntilRetirement() + " years from retirement");
		System.out.println(person2.toString());
	}

}
