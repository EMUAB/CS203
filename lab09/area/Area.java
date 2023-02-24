package lab09;

/**
 * This is class contains methods to compute area of different shapes.
 * @author
 */
public class Area {


	/**
	 * This method computes the area of a circle
	 * @param r the radius
	 * @return the value of the area of circle
	 */
	public  double circleArea (double r){

		return Math.PI * r * r;
	}

	/**
	 * This method computes the area of a triangle
	 * @param b the base
	 * @param h the height
	 * @return the value of the area of triangle
	 */
	public double triangleArea (double b, double h){
		return 0.5*(b*h);
	}


	/**
	 * This method computes the area of a square
	 * @param l the length
	 * @return the value of the area of square
	 */
	public double squareArea (double l){
		return (l*l);
	}

	/**
	 * This method computes the area of a rectangle
	 * @param l the length
	 * @param w the width
	 * @return the value of the area of rectangle
	 */
	public double rectangleArea (double l, double w){
		return l*w;
	}


}
