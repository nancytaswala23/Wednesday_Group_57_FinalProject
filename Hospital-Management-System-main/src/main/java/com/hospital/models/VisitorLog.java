package com.hospital.models;

import java.time.LocalDateTime;

public class VisitorLog {
    private int id;
    private String visitorName;
    private String purpose;
    private LocalDateTime visitTime;
    private String desk;
    private int receptionistId;

    public VisitorLog(int id, String visitorName, String purpose, LocalDateTime visitTime, String desk, int receptionistId) {
        this.id = id;
        this.visitorName = visitorName;
        this.purpose = purpose;
        this.visitTime = visitTime;
        this.desk = desk;
        this.receptionistId = receptionistId;
    }

    public int getId() { return id; }
    public String getVisitorName() { return visitorName; }
    public String getPurpose() { return purpose; }
    public LocalDateTime getVisitTime() { return visitTime; }
    public String getDesk() { return desk; }
    public int getReceptionistId() { return receptionistId; }

    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public void setVisitTime(LocalDateTime visitTime) { this.visitTime = visitTime; }
    public void setDesk(String desk) { this.desk = desk; }
    public void setReceptionistId(int receptionistId) { this.receptionistId = receptionistId; }
} 