package sample;

public class Model {

    public enum Operation {addition, subtraction, multiplication, division}

    public static double calculate(double firstOperand, double secondOperand, Operation operation) {
        double result = switch (operation) {
            case addition -> firstOperand + secondOperand;
            case subtraction -> firstOperand - secondOperand;
            case multiplication -> firstOperand * secondOperand;
            case division -> firstOperand / secondOperand;
            default -> Double.NaN;
        };
        return result;
    }
}
