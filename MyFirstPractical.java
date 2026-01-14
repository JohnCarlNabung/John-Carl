package MyFirstGUI02package;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFirstPractical {

    private JFrame frame;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfUsername;
    private JPasswordField passwordField;

    private JRadioButton rdbMale;
    private JRadioButton rdbFemale;
    private JRadioButton rdbFree;
    private JRadioButton rdbPremium;

    private JComboBox<String> comboBoxAge;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFirstPractical window = new MyFirstPractical();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MyFirstPractical() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("My First Practical");
        frame.setBounds(100, 100, 662, 444);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // FIRST NAME
        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblFirstName.setBounds(116, 30, 76, 14);
        frame.getContentPane().add(lblFirstName);

        tfFirstName = new JTextField();
        tfFirstName.setBounds(55, 55, 183, 20);
        frame.getContentPane().add(tfFirstName);

        // LAST NAME
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblLastName.setBounds(450, 30, 76, 14);
        frame.getContentPane().add(lblLastName);

        tfLastName = new JTextField();
        tfLastName.setBounds(384, 55, 197, 20);
        frame.getContentPane().add(tfLastName);

        // USERNAME
        JLabel lblUsername = new JLabel("User Name");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsername.setBounds(116, 98, 76, 14);
        frame.getContentPane().add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(55, 126, 183, 20);
        frame.getContentPane().add(tfUsername);

        // PASSWORD
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPassword.setBounds(450, 98, 76, 14);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(384, 126, 197, 20);
        frame.getContentPane().add(passwordField);

        // SEX
        JLabel lblSex = new JLabel("Sex");
        lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblSex.setBounds(86, 176, 76, 14);
        frame.getContentPane().add(lblSex);

        rdbMale = new JRadioButton("Male");
        rdbMale.setBounds(55, 197, 60, 23);
        frame.getContentPane().add(rdbMale);

        rdbFemale = new JRadioButton("Female");
        rdbFemale.setBounds(116, 197, 76, 23);
        frame.getContentPane().add(rdbFemale);

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(rdbMale);
        sexGroup.add(rdbFemale);

        // AGE
        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAge.setBounds(384, 176, 29, 14);
        frame.getContentPane().add(lblAge);

        comboBoxAge = new JComboBox<String>(
                new String[]{"11","12","13","14","15","16","17","18","19","20"}
        );
        comboBoxAge.setBounds(414, 198, 155, 20);
        frame.getContentPane().add(comboBoxAge);

        // SUBSCRIPTION
        JLabel lblSubscription = new JLabel("Subscription");
        lblSubscription.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblSubscription.setBounds(72, 236, 76, 14);
        frame.getContentPane().add(lblSubscription);

        rdbFree = new JRadioButton("Free");
        rdbFree.setBounds(55, 257, 65, 23);
        frame.getContentPane().add(rdbFree);

        rdbPremium = new JRadioButton("Premium");
        rdbPremium.setBounds(161, 257, 77, 23);
        frame.getContentPane().add(rdbPremium);

        ButtonGroup subscriptionGroup = new ButtonGroup();
        subscriptionGroup.add(rdbFree);
        subscriptionGroup.add(rdbPremium);

        // SIGN IN BUTTON
        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setBounds(383, 236, 89, 23);
        frame.getContentPane().add(btnSignIn);

        // TEXT AREA
        textArea = new JTextArea();
        textArea.setBounds(55, 300, 538, 81);
        textArea.setEditable(false);
        frame.getContentPane().add(textArea);

        // BUTTON ACTION (NO LAMBDA)
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateAndSubmit();
            }
        });
    }

    private void validateAndSubmit() {

        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        String username = tfUsername.getText().trim();
        String password = new String(passwordField.getPassword());

        if (firstName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "First Name is required");
            return;
        }

        if (lastName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Last Name is required");
            return;
        }

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Username is required");
            return;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(frame, "Password must be at least 6 characters");
            return;
        }

        if (!rdbMale.isSelected() && !rdbFemale.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Please select Sex");
            return;
        }

        if (!rdbFree.isSelected() && !rdbPremium.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Please select Subscription");
            return;
        }

        String sex = rdbMale.isSelected() ? "Male" : "Female";
        String subscription = rdbFree.isSelected() ? "Free" : "Premium";
        String age = (String) comboBoxAge.getSelectedItem();

        textArea.setText(
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Username: " + username + "\n" +
                "Sex: " + sex + "\n" +
                "Age: " + age + "\n" +
                "Subscription: " + subscription
        );
    }
}
