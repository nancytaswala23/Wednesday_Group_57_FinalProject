package com.hospital.model;

public class Pharmacist extends BaseEntity {
    private String licenseNumber;

    public Pharmacist(int id, String name, String username, int hospitalId, String licenseNumber) {
        super(id, name, username, "PHARMACIST", hospitalId);
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
} 