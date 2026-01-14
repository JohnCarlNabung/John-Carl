package CRUD;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TrafficViolationGUI extends JFrame {

    private DefaultListModel<TrafficViolation> violationListModel;
    private JList<TrafficViolation> violationJList;

    private JTextField plateField;
    private JTextField violationField;
    private JTextField fineField;

    private ArrayList<TrafficViolation> violations;

    public TrafficViolationGUI() {

        setTitle("Traffic Violation Manager");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Data
        violations = new ArrayList<TrafficViolation>();
        violationListModel = new DefaultListModel<TrafficViolation>();
        violationJList = new JList<TrafficViolation>(violationListModel);

        add(new JScrollPane(violationJList), BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Plate Number:"));
        plateField = new JTextField();
        inputPanel.add(plateField);

        inputPanel.add(new JLabel("Violation Type:"));
        violationField = new JTextField();
        inputPanel.add(violationField);

        inputPanel.add(new JLabel("Fine Amount:"));
        fineField = new JTextField();
        inputPanel.add(fineField);

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.SOUTH);

        // BUTTON ACTIONS (NO LAMBDA – SAFE)
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addViolation();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateViolation();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteViolation();
            }
        });

        // LOAD SELECTED ITEM TO TEXTFIELDS
        violationJList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    TrafficViolation v = violationJList.getSelectedValue();
                    if (v != null) {
                        plateField.setText(v.getPlateNumber());
                        violationField.setText(v.getViolationType());
                        fineField.setText(String.valueOf(v.getFineAmount()));
                    }
                }
            }
        });
    }

    // ADD
    private void addViolation() {
        String plate = plateField.getText();
        String violation = violationField.getText();
        double fine;

        try {
            fine = Double.parseDouble(fineField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid fine amount!");
            return;
        }

        TrafficViolation v = new TrafficViolation(plate, violation, fine);
        violations.add(v);
        violationListModel.addElement(v);
        clearFields();
    }

    // UPDATE
    private void updateViolation() {
        int index = violationJList.getSelectedIndex();

        if (index >= 0) {
            TrafficViolation v = violations.get(index);

            v.setPlateNumber(plateField.getText());
            v.setViolationType(violationField.getText());

            try {
                v.setFineAmount(Double.parseDouble(fineField.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid fine amount!");
                return;
            }

            violationListModel.set(index, v);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a violation to update!");
        }
    }

    // DELETE
    private void deleteViolation() {
        int index = violationJList.getSelectedIndex();

        if (index >= 0) {
            violations.remove(index);
            violationListModel.remove(index);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a violation to delete!");
        }
    }

    private void clearFields() {
        plateField.setText("");
        violationField.setText("");
        fineField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TrafficViolationGUI().setVisible(true);
            }
        });
    }
}	
