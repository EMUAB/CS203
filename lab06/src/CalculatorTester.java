import java.util.Scanner;

public class CalculatorTester {
    public static void main(String args[]) {
        // Get input from user
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first integer: ");
        int num1 = scan.nextInt();
        System.out.println("Enter your second integer: ");
        int num2 = scan.nextInt();
        scan.close();

        // Create calculator object and print results of methods
        ScientificCalculator calc = new ScientificCalculator(num1, num2);
        System.out.println("basic: " + num1 + " + " + num2 + " = " + calc.addition() + "\n"
                + num1 + " - " + num2 + " = " + calc.subtraction() + "\n"
                + num1 + " * " + num2 + " = " + calc.multiplication() + "\n"
                + num1 + " / " + num2 + " = " + calc.division());
        System.out.println("scientific: √" + num2 + " = " + calc.squareRoot() + "\n"
                + num1 + " ^ " + num2 + " = " + calc.power());
    }
}
