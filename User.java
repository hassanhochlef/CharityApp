/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author LENOVO
 */
public class User {
    
    private String firstname;
    private String lastname;
    private String phone;
    private String city;
    private String gouvernorat;
    private String mail ;
    private String role;

    public User() {
    }

    public User( String firstname, String lastname, String phone, String city, String gouvernorat, String mail, String role) {
     
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.city = city;
        this.gouvernorat = gouvernorat;
        this.mail = mail;
        this.role = role;
    }

   

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + " firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", city=" + city + ", gouvernorat=" + gouvernorat + ", mail=" + mail + ", role=" + role + '}';
    }



 
    
    
    
    
    
    
}
