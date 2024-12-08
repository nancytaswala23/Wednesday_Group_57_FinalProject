package com.hospital.model;

public class ITSupport extends BaseEntity {
    private String department;

    public ITSupport(int id, String name, String username, int hospitalId, String department) {
        super(id, name, username, "IT_SUPPORT", hospitalId);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
} 