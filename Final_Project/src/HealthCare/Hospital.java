/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

import java.util.List;

/**
 *
 * @author pranav
 */
public class Hospital {
    
    private String hospitalName;
    private String username;
    private String password;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Community getBelongsToCummunity() {
        return belongsToCummunity;
    }

    public void setBelongsToCummunity(Community belongsToCummunity) {
        this.belongsToCummunity = belongsToCummunity;
    }

    public Hospital(String hospitalName, String username, String password, Community belongsToCummunity) {
        this.hospitalName = hospitalName;
        this.username = username;
        this.password = password;
        this.belongsToCummunity = belongsToCummunity;
    }
    
   
    private Community belongsToCummunity;

    public boolean verify(String user, String pass) {
        if(this.username.equals(username) && this.password.equals(password) )return true;
       return false;}
   
}
    
   
    
    

