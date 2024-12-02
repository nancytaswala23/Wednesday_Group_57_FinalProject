package HealthCare;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rajes
 */
public class HospitalDirectory {
    private String hospitalNme;
    private String hospitalComm;
    private int hospitalIiD;

    public String getHospitalNme() {
        return hospitalNme;
    }

    public void setHospitalNme(String hospitalNme) {
        this.hospitalNme = hospitalNme;
    }

    public String getHospitalComm() {
        return hospitalComm;
    }

    public void setHospitalComm(String hospitalComm) {
        this.hospitalComm = hospitalComm;
    }

    public int getHospitalID() {
        return hospitalIiD;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalIiD = hospitalID;
    }

    public HospitalDirectory(String hospitalNme, String hospitalComm, int hospitalIiD) {
        this.hospitalNme = hospitalNme;
        this.hospitalComm = hospitalComm;
        this.hospitalIiD = hospitalIiD;
    }

   
    
}
