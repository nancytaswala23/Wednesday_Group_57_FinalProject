package com.hospital.models;

public class Department {
    private int id;
    private String name;
    private String description;
    private int staffCount;

    public Department(int id, String name, String description, int staffCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.staffCount = staffCount;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getStaffCount() { return staffCount; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setStaffCount(int staffCount) { this.staffCount = staffCount; }
} 