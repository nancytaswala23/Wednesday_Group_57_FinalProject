/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

/**
 *
 * @author pranav
 */
public class PersonDirectory {
     private String perNme;
    private String perComm;
    private int personIiD;

    public String getPerNme() {
        return perNme;
    }

    public void setPerNme(String perNme) {
        this.perNme = perNme;
    }

    public String getPerComm() {
        return perComm;
    }

    public void setPerComm(String perComm) {
        this.perComm = perComm;
    }

    public int getPersonIiD() {
        return personIiD;
    }

    public void setPersonIiD(int personIiD) {
        this.personIiD = personIiD;
    }

    public PersonDirectory(String perNme, String perComm, int personIiD) {
        this.perNme = perNme;
        this.perComm = perComm;
        this.personIiD = personIiD;
    }

   
    
    
}
