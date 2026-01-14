package MyFirstGUI02package;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFirstWindow {

    private JFrame MyFirstGui;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFirstWindow window = new MyFirstWindow();
                    window.MyFirstGui.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MyFirstWindow() {
        initialize();
        createEvent();
    }

    private void initialize() {
        MyFirstGui = new JFrame();
        MyFirstGui.setTitle("Login GUI");
        MyFirstGui.setBounds(350, 200, 600, 400);
        MyFirstGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyFirstGui.getContentPane().setLayout(null);

        // Username Label
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(150, 80, 100, 30);
        MyFirstGui.getContentPane().add(lblUsername);

        // Username Text Field
        txtUsername = new JTextField();
        txtUsername.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        txtUsername.setBounds(250, 80, 150, 30);
        MyFirstGui.getContentPane().add(txtUsername);

        // Password Label
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(150, 130, 100, 30);
        MyFirstGui.getContentPane().add(lblPassword);

        // Password Text Field
        txtPassword = new JPasswordField();
        txtPassword.setBounds(250, 130, 150, 30);
        MyFirstGui.getContentPane().add(txtPassword);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(250, 190, 100, 30);
        MyFirstGui.getContentPane().add(btnLogin);
    }

    private void createEvent() {
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String user = txtUsername.getText();
                String pass = new String(txtPassword.getPassword());

                // Simple login check
                if (user.equals("admin") && pass.equals("1234")) {
                    JOptionPane.showMessageDialog(null,
                            "Login Successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Incorrect username or password.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
