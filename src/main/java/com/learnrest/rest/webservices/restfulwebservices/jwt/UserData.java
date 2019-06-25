package com.learnrest.rest.webservices.restfulwebservices.jwt;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String fullname;
    private String city;
    private String zip;
    private long phonenumber;
    private String roles;

    public UserData(){}

    public UserData(String username, String password, String fullname, String city, String zip, long phonenumber, String roles) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.city = city;
        this.zip = zip;
        this.phonenumber = phonenumber;
        this.roles = roles;
    }


}
