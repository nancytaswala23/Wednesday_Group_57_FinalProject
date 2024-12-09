package com.hospital.models;

public class StaffSchedule {
    private int id;
    private int managerId;
    private int departmentId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private String notes;

    public StaffSchedule(int id, int managerId, int departmentId, String dayOfWeek, String startTime, String endTime, String notes) {
        this.id = id;
        this.managerId = managerId;
        this.departmentId = departmentId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.notes = notes;
    }

    public int getId() { return id; }
    public int getManagerId() { return managerId; }
    public int getDepartmentId() { return departmentId; }
    public String getDayOfWeek() { return dayOfWeek; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getNotes() { return notes; }

    public void setManagerId(int managerId) { this.managerId = managerId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public void setNotes(String notes) { this.notes = notes; }
} 