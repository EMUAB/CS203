public class ScientificCalculator extends Calculator {

    public ScientificCalculator(int a, int b) {
        super(a, b);
    }

    /**
     * Takes the square root of num1
     * @return √num1
     */
    public double squareRoot() {
        return Math.sqrt(getNum1());
    }

    /**
     * Raises num1 to the power of num2
     * @return num1^num2
     */
    public int power() {
        return (int) Math.pow(getNum1(), getNum2());
    }
}
