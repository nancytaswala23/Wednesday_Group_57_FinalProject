/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

/**
 *
 * @author pranav
 */
public class PatientDirectory {
     private String patNme;
    private String patComm;
    private int patIiD;

    public PatientDirectory(String patNme, String patComm, int patIiD) {
        this.patNme = patNme;
        this.patComm = patComm;
        this.patIiD = patIiD;
    }

   
    public String getPatNme() {
        return patNme;
    }

    public void setPatNme(String patNme) {
        this.patNme = patNme;
    }

    public String getPatComm() {
        return patComm;
    }

    public void setPatComm(String patComm) {
        this.patComm = patComm;
    }

    public int getPatIiD() {
        return patIiD;
    }

    public void setPatIiD(int patIiD) {
        this.patIiD = patIiD;
    }
    
    
}
