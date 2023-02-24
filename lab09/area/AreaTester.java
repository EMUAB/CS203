package lab09;

import java.util.Scanner;

/**
 * This is a tester class to test the class Area. 
 * @author 
 *
 */
public class AreaTester {
	
	public static void main(String[] args){
		
		int check;
		boolean loop = true;
		
		Scanner in = new Scanner(System.in);
		/*
		 * This while loop asks you to choose a shape you want to calculate the aera and 
		 * after you choose a shape, you need to enter the dimensions.
		 */
		while (loop){
			
			System.out.println("\nSelect shape:\n 1: Circle \n 2: Triangle \n 3: Square \n 4: Rectangle \n 5: Exit");
			System.out.println("Enter your choice: ");
			check = in.nextInt();
		
			switch (check){
				/* Case for calculate Area of circle*/
				case 1:
					double r;
					System.out.println("Enter radius:");
					r = in.nextDouble();
					Area circle = new Area();
					double areaOfCircle = circle.circleArea(r);
					System.out.println("Your Area of Circle is: " + areaOfCircle);
					break;
					
				/* Case for calculate Area of Triangle*/	
				case 2:
					double b,h;
					System.out.println("Enter base length:");
					b = in.nextDouble();
					System.out.println("Enter height:");
					h = in.nextDouble();
					Area triangle = new Area();
					double areaofTriangle = triangle.triangleArea(b,h);
					System.out.println("Your Area of Triangle is: " + areaofTriangle);
					break;
					
				/* Case for calculate Area of Square*/
				case 3:
					double l;
					System.out.println("Enter side length:");
					l = in.nextDouble();
					Area square = new Area();
					double areaOfSquare = square.squareArea(l);
					System.out.println("Your Area of Square is: " + areaOfSquare);
					break;
					
				/* Case for calculate Area of Rectangle*/
				case 4:
					double bL,hL;
					System.out.println("Enter length:");
					bL = in.nextDouble();
					System.out.println("Enter height:");
					hL = in.nextDouble();
					Area rectangle = new Area();
					double areaOfRectangle = rectangle.rectangleArea(bL,hL);
					System.out.println("Your Area of Rectangle is: " + areaOfRectangle);
					break;
					
				/* Case for Exit from program*/
				case 5: 
					System.out.println("Bye have great day!!!");
					System.exit(0);
				
				/* Case for for user mistake*/
				default:
					System.out.println("Please select correct option");
			}
		}
		in.close();
	}
	

}
