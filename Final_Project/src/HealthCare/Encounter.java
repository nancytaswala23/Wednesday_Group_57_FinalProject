/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

/**
 *
 * @author taswa
 */
public class Encounter {
    public Doctor doctor;
    public Patient patient;
    public String vitalSigns;

    public Encounter(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        vitalSigns = "";
    }
    
}
