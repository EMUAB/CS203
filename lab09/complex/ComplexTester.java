package lab09;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ComplexTester {
	public static void main(String[] args) {
		Complex c1, c2;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the real and imaginary parts for c1: ");

		double r1 = scan.nextDouble();
		double i1 = scan.nextDouble();

		c1 = new Complex(r1, i1);
		System.out.println();

		System.out.print("Enter the real and imaginary parts for c2: ");

		double r2 = scan.nextDouble();
		double i2 = scan.nextDouble();

		c2 = new Complex(r2, i2);
		System.out.println();

		System.out.println("Test add(): ");
		System.out.println("c1 + c2 = " + c1.add(c2));
		System.out.println();

		System.out.println("Test subtract(): ");
		System.out.println("c1 - c2 = " + c1.subtract(c2));
		System.out.println();

		System.out.println("Test multiply(): ");
		System.out.println("c1 * c2 = " + c1.multiply(c2));
		System.out.println();

		System.out.println("Test divide(): ");
		System.out.println("c1 / c2 = " + c1.divide(c2));
		System.out.println();

		System.out.println("Test abs(): ");
		DecimalFormat fmt = new DecimalFormat("0.000");
		System.out.println("c1 abs: " + fmt.format(c1.abs()));
		System.out.println("c2 abs: " + fmt.format(c2.abs()));
		System.out.println();

		System.out.println("Test equals(): ");

		if (c1.equals(c2)) {
			System.out.println("c1 is equal to c2");
		} else {
			System.out.println("c1 is not equal to c2");
		}
		scan.close();
	}
}
