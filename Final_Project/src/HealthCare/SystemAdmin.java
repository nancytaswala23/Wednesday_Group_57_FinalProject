/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class SystemAdmin {
    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static ArrayList<Patient>  patientList = new ArrayList<>();
    public static ArrayList<Hospital>  hospitalList = new ArrayList<>();
    public static ArrayList<Community>  communityList = new ArrayList<>();
    public static ArrayList<House>  houseList = new ArrayList<>();
    public static ArrayList<Encounter>  encounterList = new ArrayList<>();
    public static ArrayList<City>  cityList = new ArrayList<>(){{
        add(new City("Boston", 02120));
        add(new City("Lowell", 02121));
        add(new City("Cambridge", 02122));
        add(new City("Quincy", 02123));
        
    }};
}
