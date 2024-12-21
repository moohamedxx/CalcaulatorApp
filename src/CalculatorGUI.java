import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private Calculator calculator;

    private JFrame frame;
    private JTextField numberOneTB;
    private JTextField numberTwoTB;
    private JLabel finalAnswerLabel;
    private JRadioButton additionOption;
    private JRadioButton subtractionOption;
    private JRadioButton multiplicationOption;
    private JRadioButton divisionOption;
    private ButtonGroup operationGroup;

    public CalculatorGUI() {
        calculator = new Calculator();
        initializeGUI();
    }

    private void initializeGUI() {
        // Initialize Frame
        frame = new JFrame("Enhanced Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Labels
        JLabel numberOneLabel = new JLabel("Enter First Number:");
        numberOneLabel.setBounds(30, 20, 150, 30);

        JLabel numberTwoLabel = new JLabel("Enter Second Number:");
        numberTwoLabel.setBounds(30, 70, 150, 30);

        JLabel operationLabel = new JLabel("Choose Operation:");
        operationLabel.setBounds(30, 120, 150, 30);

        finalAnswerLabel = new JLabel("Result: ");
        finalAnswerLabel.setBounds(30, 220, 300, 30);

        // Text Fields
        numberOneTB = new JTextField();
        numberOneTB.setBounds(180, 20, 150, 30);

        numberTwoTB = new JTextField();
        numberTwoTB.setBounds(180, 70, 150, 30);

        // Radio Buttons
        additionOption = new JRadioButton("Addition");
        subtractionOption = new JRadioButton("Subtraction");
        multiplicationOption = new JRadioButton("Multiplication");
        divisionOption = new JRadioButton("Division");

        additionOption.setBounds(180, 120, 100, 30);
        subtractionOption.setBounds(280, 120, 100, 30);
        multiplicationOption.setBounds(180, 150, 100, 30);
        divisionOption.setBounds(280, 150, 100, 30);

        // Group Radio Buttons
        operationGroup = new ButtonGroup();
        operationGroup.add(additionOption);
        operationGroup.add(subtractionOption);
        operationGroup.add(multiplicationOption);
        operationGroup.add(divisionOption);

        // Button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 190, 100, 30);
        calculateButton.addActionListener(new CalculateActionListener());

        // Add Components to Frame
        frame.add(numberOneLabel);
        frame.add(numberTwoLabel);
        frame.add(operationLabel);
        frame.add(finalAnswerLabel);
        frame.add(numberOneTB);
        frame.add(numberTwoTB);
        frame.add(additionOption);
        frame.add(subtractionOption);
        frame.add(multiplicationOption);
        frame.add(divisionOption);
        frame.add(calculateButton);

        // Display Frame
        frame.setVisible(true);
    }

    private class CalculateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get Input Values
                double numberOne = Double.parseDouble(numberOneTB.getText());
                double numberTwo = Double.parseDouble(numberTwoTB.getText());

                // Perform Calculation Based on Selected Operation
                double result = 0;
                if (additionOption.isSelected()) {
                    result = calculator.addition(numberOne, numberTwo);
                } else if (subtractionOption.isSelected()) {
                    result = calculator.subtraction(numberOne, numberTwo);
                } else if (multiplicationOption.isSelected()) {
                    result = calculator.multiplication(numberOne, numberTwo);
                } else if (divisionOption.isSelected()) {
                    result = calculator.division(numberOne, numberTwo);
                } else {
                    finalAnswerLabel.setText("Please select an operation.");
                    return;
                }

                // Display Result
                finalAnswerLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                finalAnswerLabel.setText("Invalid input. Please enter valid numbers.");
            } catch (ArithmeticException ex) {
                finalAnswerLabel.setText("Error: " + ex.getMessage());
            }
        }
    }
}
