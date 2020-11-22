package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    private double firstOperand;
    private double secondOperand;
    private Model.Operation operation;
    private boolean isNewNumber = true;

    @FXML
    TextField displayTextField = new TextField();

    @FXML
    private void inputDigitAction(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (value.equals("0") && displayTextField.getText().equals("0")) {
            return;
        }
        if (value.equals(".")) {
            if (isNewNumber) {
                value = "0.";
            } else {
                if (displayTextField.getText().contains(".")) {
                    return;
                }
            }
        }
        if (isNewNumber) {
            displayTextField.clear();
            isNewNumber = false;
        }
        displayTextField.setText(displayTextField.getText() + value);
    }

    @FXML
    private void inputOperationAction(ActionEvent event) {
        firstOperand = Double.parseDouble(displayTextField.getText());
        String value = ((Button) event.getSource()).getText();
        operation = switch (value) {
            case "+" -> Model.Operation.addition;
            case "-" -> Model.Operation.subtraction;
            case "*" -> Model.Operation.multiplication;
            case "/" -> Model.Operation.division;
            default -> null;
        };
        isNewNumber = true;
    }

    @FXML
    private void resultOperationAction(ActionEvent event) {
        if (isNewNumber)
            firstOperand = Double.parseDouble(displayTextField.getText());
        else
            secondOperand = Double.parseDouble(displayTextField.getText());
        double result = Model.calculate(firstOperand, secondOperand, operation);
        displayTextField.setText(String.valueOf(result));
        isNewNumber = true;
    }

}