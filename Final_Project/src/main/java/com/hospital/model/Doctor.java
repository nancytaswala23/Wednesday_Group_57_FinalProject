package com.hospital.model;

public class Doctor extends BaseEntity {
    private String specialization;
    private String licenseNumber;

    public Doctor(int id, String name, String username, String specialization, int hospitalId, String licenseNumber) {
        super(id, name, username, "DOCTOR", hospitalId);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
} 