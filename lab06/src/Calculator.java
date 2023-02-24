public class Calculator {
    private int num1, num2;

    /**
     * This is the Constructor for the Calculator class.
     * The Calculator class takes two integers. The class
     * provides methods to add, subtract, multiply, and divide these two integers.
     *
     * @param a an int representing the first number
     * @param b an int representing the second number
     */
    public Calculator(int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    /**
     * Adds two numbers
     * @return num1-num2
     */
    public int addition() {
        return getNum1() + getNum2();
    }

    /**
     * Subtracts two numbers
     * @return num1-num2
     */
    public int subtraction() {
        return getNum1() - getNum2();
    }

    /**
     * Multiplies two numbers
     * @return num1*num2
     */
    public int multiplication() {
        return getNum1() * getNum2();
    }

    /**
     * Divides two numbers
     * @return num1/num2
     */
    public double division() {
        return (double) getNum1() / (double) getNum2();
    }
}
