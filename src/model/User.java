/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mlahi
 */
public class User {

    private final String name;
    private final String mail;
    private final String nic;
    private final String email;
    private final String region;
    private final String country;
    private final String address;
    private final String description;

    // Constructor to initialize the fields
    public User(String name, String mail, String nic, String email, String region, String country, String address, String description) {
        this.name = name;
        this.mail = mail;
        this.nic = nic;
        this.email = email;
        this.region = region;
        this.country = country;
        this.address = address;
        this.description = description;
    }

    // Getters for each field
    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getNic() {
        return nic;
    }

    public String getEmail() {
        return email;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", mail='" + mail + '\''
                + ", nic='" + nic + '\''
                + ", email='" + email + '\''
                + ", region='" + region + '\''
                + ", country='" + country + '\''
                + ", address='" + address + '\''
                + ", description='" + description + '\''
                + '}';
    }
}
