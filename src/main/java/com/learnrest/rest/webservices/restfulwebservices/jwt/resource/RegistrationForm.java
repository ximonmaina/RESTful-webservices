package com.learnrest.rest.webservices.restfulwebservices.jwt.resource;

import com.learnrest.rest.webservices.restfulwebservices.jwt.JwtUserDetails;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor()
public class RegistrationForm {


    private  String username;
    private  String password;
    private  String fullname;
    private String city;
    private String zip;
    private int phonenumber;
    private String roles;


//    public JwtUserDetails toUser(JwtUserDetails jwtUserDetails, PasswordEncoder passwordEncoder) {
//
//    }


}
