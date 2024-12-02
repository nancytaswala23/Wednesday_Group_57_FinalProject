/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

/**
 *
 * @author taswa
 */
public class Community {
    private String communityName;
    private City city;
    private String username;
    private String password;

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

    

    @Override
    public String toString() {
        return "Community{" + "communityName=" + communityName + ", city=" + city + '}';
    }
   

    public Community(String communityName, City city,String username, String password) {
        this.communityName = communityName;
        this.city = city;
           this.username = username;
        this.password = password;
       
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean verify(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
    
    
}
