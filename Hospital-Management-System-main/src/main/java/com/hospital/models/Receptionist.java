package com.hospital.models;

public class Receptionist extends User {
    private String shift;
    private String contactNumber;
    private boolean available;
    private String desk;

    public Receptionist(int id, String name, String username, int hospitalId, String shift, String contactNumber, String desk) {
        super(id, name, username, "RECEPTIONIST", hospitalId);
        this.shift = shift;
        this.contactNumber = contactNumber;
        this.available = true;
        this.desk = desk;
    }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getDesk() { return desk; }
    public void setDesk(String desk) { this.desk = desk; }

    @Override
    public String toString() {
        return getName();
    }
} 