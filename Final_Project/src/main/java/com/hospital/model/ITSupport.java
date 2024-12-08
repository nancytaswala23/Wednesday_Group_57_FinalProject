package com.hospital.model;

// Represents IT support staff in the hospital
public class ITSupport extends BaseEntity {
    private String department; // IT support department
    private String contactNumber; // IT support contact number

    // Constructor to initialize IT support details
    public ITSupport(int id, String name, String username, int hospitalId, String department) {
        super(id, name, username, "IT_SUPPORT", hospitalId); // Initialize base entity properties
        this.department = department;
    }

    // Returns the department of IT support
    public String getDepartment() {
        return department;
    }

    // Updates the department of IT support
    public void setDepartment(String department) {
        this.department = department;
    }

    // Returns the contact number of IT support
    public String getContactNumber() {
        return contactNumber;
    }

    // Updates the contact number of IT support
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Returns the unique ID of IT support staff
    public int getITSupportId() {
        return getId(); // Calls method from BaseEntity
    }
}
