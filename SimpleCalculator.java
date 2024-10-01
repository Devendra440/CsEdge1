import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {
    // Declare components
    private TextField input1;
    private TextField input2;
    private TextField result;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private Button clearButton;

    public SimpleCalculator() {
        // Set up the frame
        setTitle("Simple Calculator");
        setSize(400, 400); // Increased size for better appearance
        setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Add margin between components

        Font font = new Font("SansSerif", Font.BOLD, 16); // Set a larger font

        // Initialize components
        input1 = new TextField();
        input2 = new TextField();
        result = new TextField();
        result.setEditable(false);
        result.setBackground(Color.LIGHT_GRAY); // Make the result field stand out

        input1.setFont(font);
        input2.setFont(font);
        result.setFont(font);

        addButton = new Button("Add");
        subtractButton = new Button("Subtract");
        multiplyButton = new Button("Multiply");
        divideButton = new Button("Divide");
        clearButton = new Button("Clear");

        Button[] buttons = { addButton, subtractButton, multiplyButton, divideButton, clearButton };
        for (Button button : buttons) {
            button.setFont(font);
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE); // Add contrasting text color
        }

        // Add action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Set GridBagLayout positions for components
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new Label("Input 1:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(input1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new Label("Input 2:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(input2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new Label("Result:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(result, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(subtractButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(multiplyButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(divideButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Span across both columns
        add(clearButton, gbc);

        // Set frame visibility and close operation
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Action performed method
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Get input values
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double res = 0;

            // Determine which button was pressed
            if (e.getSource() == addButton) {
                res = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                res = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                res = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                res = num1 / num2;
            } else if (e.getSource() == clearButton) {
                clearFields();
                return;
            }
            // Display result
            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Invalid input!");
        } catch (ArithmeticException ex) {
            result.setText(ex.getMessage());
        }
    }

    // Method to clear input and result fields
    private void clearFields() {
        input1.setText("");
        input2.setText("");
        result.setText("");
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
