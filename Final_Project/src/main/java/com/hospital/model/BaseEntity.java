package com.hospital.model;

public class BaseEntity {
    protected int id;
    protected String name;
    protected String username;
    protected String role;
    protected int hospitalId;

    public BaseEntity(int id, String name, String username, String role, int hospitalId) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.role = role;
        this.hospitalId = hospitalId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }
} 