/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

import java.util.List;

/**
 *
 * @author taswa
 */
public class City {
    public String cityName;
    public int zipCode;

    public City(String cityName, int zipCode) {
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "City{" + "cityName=" + cityName + ", zipCode=" + zipCode + '}';
    }
   
    
    
    
}
