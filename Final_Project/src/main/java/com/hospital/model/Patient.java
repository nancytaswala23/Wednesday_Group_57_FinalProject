package com.hospital.model;

public class Patient extends BaseEntity {
    private String gender;
    private String dateOfBirth;
    private String bloodGroup;
    private String contactNumber;
    private String medicalHistory;
    private String allergies;
    private int dieticianId;

    public Patient(int id, String name, String username, int hospitalId, int dieticianId) {
        super(id, name, username, "PATIENT", hospitalId);
        this.dieticianId = dieticianId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public int getDieticianId() {
        return dieticianId;
    }

    public void setDieticianId(int dieticianId) {
        this.dieticianId = dieticianId;
    }
} 