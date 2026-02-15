package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CalculatorUI class provides a simple Swing-based UI for the Calculator.
 */
public class CalculatorUI extends JFrame {
    private final Calculator calculator;
    private final JTextField display;
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public CalculatorUI() {
        calculator = new Calculator();
        display = new JTextField("0");
        display.setName("display");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(createButtonsPanel(), BorderLayout.CENTER);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }
        return panel;
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.matches("[0-9.]")) {
                if (startNewNumber) {
                    display.setText(cmd.equals(".") ? "0." : cmd);
                    startNewNumber = false;
                } else {
                    if (cmd.equals(".") && display.getText().contains(".")) {
                        return;
                    }
                    display.setText(display.getText() + cmd);
                }
            } else if (cmd.matches("[+\\-*/]")) {
                firstOperand = Double.parseDouble(display.getText());
                operator = cmd;
                startNewNumber = true;
            } else if (cmd.equals("=")) {
                double secondOperand = Double.parseDouble(display.getText());
                double result = 0;
                try {
                    switch (operator) {
                        case "+": result = calculator.add(firstOperand, secondOperand); break;
                        case "-": result = calculator.subtract(firstOperand, secondOperand); break;
                        case "*": result = calculator.multiply(firstOperand, secondOperand); break;
                        case "/": result = calculator.divide(firstOperand, secondOperand); break;
                    }
                    display.setText(Double.toString(result));
                } catch (ArithmeticException ex) {
                    display.setText("Error");
                }
                startNewNumber = true;
            } else if (cmd.equals("C")) {
                display.setText("0");
                firstOperand = 0;
                operator = "";
                startNewNumber = true;
            }
        }
    }
}
