package MyFirstGUI02package;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI {

    private JFrame frame;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JLabel lblResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BMI window = new BMI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public BMI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("BMI Calculator");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblHeight = new JLabel("Height (m):");
        lblHeight.setBounds(50, 50, 100, 25);
        frame.getContentPane().add(lblHeight);

        txtHeight = new JTextField();
        txtHeight.setBounds(150, 50, 150, 25);
        frame.getContentPane().add(txtHeight);

        JLabel lblWeight = new JLabel("Weight (kg):");
        lblWeight.setBounds(50, 100, 100, 25);
        frame.getContentPane().add(lblWeight);

        txtWeight = new JTextField();
        txtWeight.setBounds(150, 100, 150, 25);
        frame.getContentPane().add(txtWeight);

        JButton btnCalculate = new JButton("Calculate BMI");
        btnCalculate.setBounds(150, 150, 150, 30);
        frame.getContentPane().add(btnCalculate);

        lblResult = new JLabel("Your BMI will appear here");
        lblResult.setBounds(50, 200, 300, 25);
        frame.getContentPane().add(lblResult);

        // Action listener for button
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double height = Double.parseDouble(txtHeight.getText());
                    double weight = Double.parseDouble(txtWeight.getText());
                    double bmiValue = weight / (height * height);

                    String category;
                    if (bmiValue < 18.5) {
                        category = "Underweight";
                    } else if (bmiValue < 24.9) {
                        category = "Normal weight";
                    } else if (bmiValue < 29.9) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    lblResult.setText(String.format("BMI: %.2f (%s)", bmiValue, category));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Please enter valid numbers!");
                }
            }
        });
    }
}
