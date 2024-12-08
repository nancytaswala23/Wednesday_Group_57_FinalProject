package com.hospital.models;

public class StaffManager extends User {
    private String department;
    private String contactNumber;
    private int teamSize;
    private boolean available;

    public StaffManager(int id, String name, String username, int hospitalId, String department, String contactNumber, int teamSize) {
        super(id, name, username, "STAFF_MANAGER", hospitalId);
        this.department = department;
        this.contactNumber = contactNumber;
        this.teamSize = teamSize;
        this.available = true;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public int getTeamSize() { return teamSize; }
    public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return getName();
    }
} 