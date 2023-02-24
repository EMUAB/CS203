public class Calculation {
    // Below vars make setting what the calculation type to be easier
    public static final int ADDITION = 0;
    public static final int SUBTRACTION = 1;
    public static final int MULTIPLICATION = 2;
    public static final int DIVISION = 3;
    public static final int SQUARE_ROOT = 4;

    public static double doFunction(double num1, double num2, int function) {
        return switch (function) {
            case 0 -> num1 + num2;
            case 1 -> num1 - num2;
            case 2 -> num1 * num2;
            case 3 -> num1 / num2;
            default -> 0;
        };
    }
}
