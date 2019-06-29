package com.learnrest.rest.webservices.restfulwebservices.userregistration.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "user")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    @Column(name = "password", nullable = false, unique = true, length = 255)
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "country", length = 20)
    private String country;
    @Column(name = "county", length = 20)
    private String county;
    @Column(name = "phone_number", length = 20, unique = true)
    private String phoneNumber;
    @Column(name = "roles")
    private String roles;
    @Column(name = "id_number", unique = true)
    private long idNumber;
    @Column(name = "email_address", unique = true)
    private String emailAddress;
    @Column(name = "po_box_address")
    private String poBoxAddress;
    @Column(name = "join_date")
    private Date joinDate;


    public UserData(){}

    public UserData(String userName, String password, String firstName, String lastName,
                    String middleName, String displayName, String country, String county,
                    String phoneNumber, String roles, long idNumber, String emailAddress,
                    String poBoxAddress) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.displayName = displayName;
        this.country = country;
        this.county = county;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
        this.idNumber = idNumber;
        this.emailAddress = emailAddress;
        this.poBoxAddress = poBoxAddress;
    }
}
