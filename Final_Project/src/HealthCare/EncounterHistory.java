/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

/**
 *
 * @author rajes
 */
public class EncounterHistory {
     public Doctor doctor13;
    public Patient patient13;
    public String vitalSigns13;

    public EncounterHistory(Doctor doctor13, Patient patient13, String vitalSigns13) {
        this.doctor13 = doctor13;
        this.patient13 = patient13;
        this.vitalSigns13 = vitalSigns13;
    }

    public Doctor getDoctor13() {
        return doctor13;
    }

    public void setDoctor13(Doctor doctor13) {
        this.doctor13 = doctor13;
    }

    public Patient getPatient13() {
        return patient13;
    }

    public void setPatient13(Patient patient13) {
        this.patient13 = patient13;
    }

    public String getVitalSigns13() {
        return vitalSigns13;
    }

    public void setVitalSigns13(String vitalSigns13) {
        this.vitalSigns13 = vitalSigns13;
    }
    
}
