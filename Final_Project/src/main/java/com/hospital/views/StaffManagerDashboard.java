package com.hospital.views;

import com.hospital.models.*;
import com.hospital.data.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StaffManagerDashboard extends BaseDashboard {
    private static final Logger logger = LoggerFactory.getLogger(StaffManagerDashboard.class);
    private JPanel menuPanel;
    private final DataStore dataStore;
    private DefaultTableModel scheduleTableModel;
    private DefaultTableModel staffTableModel;
    private final StaffManager currentManager;

    public StaffManagerDashboard(User user) {
        super(user);
        this.dataStore = DataStore.getInstance();
        this.currentManager = (StaffManager) user;
        setTitle("Staff Manager Dashboard - " + user.getName());
        initializeMenu();
        setVisible(true);
    }

    @Override
    protected void initializeMenu() {
        menuPanel = new JPanel(new GridLayout(7, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton staffButton = createMenuButton("Staff List");
        JButton schedulesButton = createMenuButton("Schedules");
        JButton departmentsButton = createMenuButton("Departments");
        JButton performanceButton = createMenuButton("Performance");
        JButton reportsButton = createMenuButton("Reports");
        JButton profileButton = createMenuButton("Profile");
        JButton logoutButton = createMenuButton("Logout");

        staffButton.addActionListener(e -> showPanel(createStaffListPanel()));
        schedulesButton.addActionListener(e -> showPanel(createSchedulesPanel()));
        departmentsButton.addActionListener(e -> showPanel(createDepartmentsPanel()));
        performanceButton.addActionListener(e -> showPanel(createPerformancePanel()));
        reportsButton.addActionListener(e -> showPanel(createReportsPanel()));
        profileButton.addActionListener(e -> showPanel(createProfilePanel()));
        logoutButton.addActionListener(e -> logout());

        menuPanel.add(staffButton);
        menuPanel.add(schedulesButton);
        menuPanel.add(departmentsButton);
        menuPanel.add(performanceButton);
        menuPanel.add(reportsButton);
        menuPanel.add(profileButton);
        menuPanel.add(logoutButton);

        add(menuPanel, BorderLayout.WEST);
        showPanel(createStaffListPanel());
    }

    protected JPanel createStaffListPanel() {
        JPanel panel = createFormPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Create staff table
        staffTableModel = new DefaultTableModel(
            new Object[]{"ID", "Name", "Role", "Department", "Contact"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable staffTable = new JTable(staffTableModel);
        JScrollPane scrollPane = new JScrollPane(staffTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add control panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshStaffTable());
        controlPanel.add(refreshButton);
        panel.add(controlPanel, BorderLayout.NORTH);

        // Load initial data
        refreshStaffTable();

        return panel;
    }

    private void refreshStaffTable() {
        staffTableModel.setRowCount(0);
        List<User> users = dataStore.getAllUsers();
        for (User user : users) {
            if (user.getHospitalId() == currentManager.getHospitalId()) {
                staffTableModel.addRow(new Object[]{
                    user.getId(),
                    user.getName(),
                    user.getRole(),
                    currentManager.getDepartment(),
                    user instanceof StaffManager ? ((StaffManager) user).getContactNumber() : "N/A"
                });
            }
        }
    }

    protected JPanel createSchedulesPanel() {
        JPanel panel = createFormPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Create schedule table
        scheduleTableModel = new DefaultTableModel(
            new Object[]{"Day", "Start Time", "End Time", "Department", "Notes"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable scheduleTable = new JTable(scheduleTableModel);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add control panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshButton = new JButton("Refresh");
        JButton addButton = new JButton("Add Schedule");

        refreshButton.addActionListener(e -> refreshScheduleTable());
        addButton.addActionListener(e -> showAddScheduleDialog());

        controlPanel.add(refreshButton);
        controlPanel.add(addButton);
        panel.add(controlPanel, BorderLayout.NORTH);

        // Load initial data
        refreshScheduleTable();

        return panel;
    }

    private void refreshScheduleTable() {
        scheduleTableModel.setRowCount(0);
        List<StaffSchedule> schedules = dataStore.getStaffSchedulesByManager(currentManager.getId());
        for (StaffSchedule schedule : schedules) {
            Department dept = dataStore.getDepartment(schedule.getDepartmentId());
            scheduleTableModel.addRow(new Object[]{
                schedule.getDayOfWeek(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                dept != null ? dept.getName() : "Unknown",
                schedule.getNotes()
            });
        }
    }

    private void showAddScheduleDialog() {
        JDialog dialog = new JDialog(this, "Add New Schedule", true);
        dialog.setLayout(new GridLayout(6, 2, 10, 10));
        dialog.setSize(300, 250);

        JTextField dayField = new JTextField();
        JTextField startTimeField = new JTextField();
        JTextField endTimeField = new JTextField();
        JTextField notesField = new JTextField();

        dialog.add(new JLabel("Day of Week:"));
        dialog.add(dayField);
        dialog.add(new JLabel("Start Time:"));
        dialog.add(startTimeField);
        dialog.add(new JLabel("End Time:"));
        dialog.add(endTimeField);
        dialog.add(new JLabel("Notes:"));
        dialog.add(notesField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            if (!dayField.getText().isEmpty() && !startTimeField.getText().isEmpty() && !endTimeField.getText().isEmpty()) {
                StaffSchedule newSchedule = new StaffSchedule(
                    dataStore.getNextId(),
                    currentManager.getId(),
                    1, // Default department ID
                    dayField.getText(),
                    startTimeField.getText(),
                    endTimeField.getText(),
                    notesField.getText()
                );
                dataStore.addStaffSchedule(newSchedule);
                refreshScheduleTable();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Please fill all required fields");
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.add(saveButton);
        dialog.add(cancelButton);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    protected JPanel createDepartmentsPanel() {
        JPanel panel = createFormPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Create department info panel
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        Department dept = dataStore.getDepartment(1); // Get current department
        if (dept != null) {
            addInfoField(infoPanel, "Department Name:", dept.getName(), gbc);
            addInfoField(infoPanel, "Description:", dept.getDescription(), gbc);
            addInfoField(infoPanel, "Staff Count:", String.valueOf(dept.getStaffCount()), gbc);
        }

        panel.add(infoPanel, BorderLayout.NORTH);
        return panel;
    }

    private void addInfoField(JPanel panel, String label, String value, GridBagConstraints gbc) {
        gbc.gridx = 0;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(value), gbc);
        gbc.gridy++;
    }

    protected JPanel createPerformancePanel() {
        JPanel panel = createFormPanel();
        // TODO: Implement performance tracking
        return panel;
    }

    protected JPanel createReportsPanel() {
        JPanel panel = createFormPanel();
        // TODO: Implement reports generation
        return panel;
    }

    protected JPanel createProfilePanel() {
        JPanel panel = createFormPanel();
        GridBagConstraints gbc = createGridBagConstraints();

        addProfileField(panel, "Name", currentUser.getName(), gbc);
        addProfileField(panel, "Role", currentUser.getRole(), gbc);
        addProfileField(panel, "Hospital ID", String.valueOf(currentUser.getHospitalId()), gbc);
        addProfileField(panel, "Email", currentUser.getEmail(), gbc);
        addProfileField(panel, "Department", currentManager.getDepartment(), gbc);
        addProfileField(panel, "Contact", currentManager.getContactNumber(), gbc);
        addProfileField(panel, "Team Size", String.valueOf(currentManager.getTeamSize()), gbc);

        return panel;
    }
} 