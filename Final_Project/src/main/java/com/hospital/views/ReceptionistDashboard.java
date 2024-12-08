package com.hospital.views;

import com.hospital.models.*;
import com.hospital.data.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceptionistDashboard extends BaseDashboard {
    private static final Logger logger = LoggerFactory.getLogger(ReceptionistDashboard.class);
    private JPanel menuPanel;
    private final DataStore dataStore;
    private DefaultTableModel visitorTableModel;
    private DefaultTableModel appointmentTableModel;
    private final Receptionist currentReceptionist;

    public ReceptionistDashboard(User user) {
        super(user);
        this.dataStore = DataStore.getInstance();
        this.currentReceptionist = (Receptionist) user;
        setTitle("Receptionist Dashboard - " + user.getName());
        initializeMenu();
        setVisible(true);
    }

    @Override
    protected void initializeMenu() {
        menuPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton appointmentsButton = createMenuButton("Appointments");
        JButton visitorsButton = createMenuButton("Visitors");
        JButton checkInButton = createMenuButton("Check-In");
        JButton enquiriesButton = createMenuButton("Enquiries");
        JButton profileButton = createMenuButton("Profile");
        JButton logoutButton = createMenuButton("Logout");

        appointmentsButton.addActionListener(e -> showPanel(createAppointmentsPanel()));
        visitorsButton.addActionListener(e -> showPanel(createVisitorsPanel()));
        checkInButton.addActionListener(e -> showPanel(createCheckInPanel()));
        enquiriesButton.addActionListener(e -> showPanel(createEnquiriesPanel()));
        profileButton.addActionListener(e -> showPanel(createProfilePanel()));
        logoutButton.addActionListener(e -> logout());

        menuPanel.add(appointmentsButton);
        menuPanel.add(visitorsButton);
        menuPanel.add(checkInButton);
        menuPanel.add(enquiriesButton);
        menuPanel.add(profileButton);
        menuPanel.add(logoutButton);

        add(menuPanel, BorderLayout.WEST);
        showPanel(createVisitorsPanel());
    }

    protected JPanel createVisitorsPanel() {
        JPanel panel = createFormPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Create visitor table
        visitorTableModel = new DefaultTableModel(
            new Object[]{"Visitor Name", "Purpose", "Visit Time", "Desk"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable visitorTable = new JTable(visitorTableModel);
        JScrollPane scrollPane = new JScrollPane(visitorTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add control panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshButton = new JButton("Refresh");
        JButton addButton = new JButton("Add New Visitor");
        
        refreshButton.addActionListener(e -> refreshVisitorTable());
        addButton.addActionListener(e -> showAddVisitorDialog());

        controlPanel.add(refreshButton);
        controlPanel.add(addButton);
        panel.add(controlPanel, BorderLayout.NORTH);

        // Load initial data
        refreshVisitorTable();

        return panel;
    }

    private void refreshVisitorTable() {
        visitorTableModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        List<VisitorLog> logs = dataStore.getVisitorLogsByReceptionist(currentReceptionist.getId());
        for (VisitorLog log : logs) {
            visitorTableModel.addRow(new Object[]{
                log.getVisitorName(),
                log.getPurpose(),
                log.getVisitTime().format(formatter),
                log.getDesk()
            });
        }
    }

    private void showAddVisitorDialog() {
        JDialog dialog = new JDialog(this, "Add New Visitor", true);
        dialog.setLayout(new GridLayout(5, 2, 10, 10));
        dialog.setSize(300, 200);

        JTextField nameField = new JTextField();
        JTextField purposeField = new JTextField();

        dialog.add(new JLabel("Visitor Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("Purpose:"));
        dialog.add(purposeField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            if (!nameField.getText().isEmpty() && !purposeField.getText().isEmpty()) {
                VisitorLog newLog = new VisitorLog(
                    dataStore.getNextId(),
                    nameField.getText(),
                    purposeField.getText(),
                    java.time.LocalDateTime.now(),
                    currentReceptionist.getDesk(),
                    currentReceptionist.getId()
                );
                dataStore.addVisitorLog(newLog);
                refreshVisitorTable();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Please fill all fields");
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.add(saveButton);
        dialog.add(cancelButton);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    protected JPanel createProfilePanel() {
        JPanel panel = createFormPanel();
        GridBagConstraints gbc = createGridBagConstraints();

        addProfileField(panel, "Name", currentUser.getName(), gbc);
        addProfileField(panel, "Role", currentUser.getRole(), gbc);
        addProfileField(panel, "Hospital ID", String.valueOf(currentUser.getHospitalId()), gbc);
        addProfileField(panel, "Email", currentUser.getEmail(), gbc);
        addProfileField(panel, "Shift", currentReceptionist.getShift(), gbc);
        addProfileField(panel, "Desk", currentReceptionist.getDesk(), gbc);
        addProfileField(panel, "Contact", currentReceptionist.getContactNumber(), gbc);

        return panel;
    }

    protected JPanel createAppointmentsPanel() {
        JPanel panel = createFormPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Create appointments table
        appointmentTableModel = new DefaultTableModel(
            new Object[]{"Patient Name", "Doctor", "Time", "Purpose", "Status"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable appointmentTable = new JTable(appointmentTableModel);
        JScrollPane scrollPane = new JScrollPane(appointmentTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add control panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshAppointmentTable());
        controlPanel.add(refreshButton);
        panel.add(controlPanel, BorderLayout.NORTH);

        // Load initial data
        refreshAppointmentTable();

        return panel;
    }

    private void refreshAppointmentTable() {
        appointmentTableModel.setRowCount(0);
        List<Appointment> appointments = dataStore.getAllAppointments();
        for (Appointment appointment : appointments) {
            User patient = dataStore.getUser(appointment.getPatientId());
            User doctor = dataStore.getUser(appointment.getDoctorId());
            appointmentTableModel.addRow(new Object[]{
                patient != null ? patient.getName() : "Unknown",
                doctor != null ? doctor.getName() : "Unknown",
                appointment.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                appointment.getPurpose(),
                appointment.getStatus()
            });
        }
    }

    protected JPanel createCheckInPanel() {
        JPanel panel = createFormPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField patientIdField = new JTextField(20);
        JButton checkInButton = new JButton("Check In");

        formPanel.add(new JLabel("Patient ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(patientIdField, gbc);
        gbc.gridx = 2;
        formPanel.add(checkInButton, gbc);

        checkInButton.addActionListener(e -> {
            String patientId = patientIdField.getText();
            if (!patientId.isEmpty()) {
                // TODO: Implement check-in logic
                JOptionPane.showMessageDialog(this, "Patient checked in successfully");
                patientIdField.setText("");
            }
        });

        panel.add(formPanel, BorderLayout.NORTH);
        return panel;
    }

    protected JPanel createEnquiriesPanel() {
        JPanel panel = createFormPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JTextArea enquiryArea = new JTextArea(5, 30);
        enquiryArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(enquiryArea);

        JButton submitButton = new JButton("Submit Enquiry");
        submitButton.addActionListener(e -> {
            if (!enquiryArea.getText().isEmpty()) {
                // TODO: Implement enquiry submission logic
                JOptionPane.showMessageDialog(this, "Enquiry submitted successfully");
                enquiryArea.setText("");
            }
        });

        panel.add(new JLabel("Enter enquiry details:"), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        return panel;
    }
} 