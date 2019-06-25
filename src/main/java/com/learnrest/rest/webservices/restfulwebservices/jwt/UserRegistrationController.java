package com.learnrest.rest.webservices.restfulwebservices.jwt;

import com.learnrest.rest.webservices.restfulwebservices.jwt.resource.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/register")
@CrossOrigin("http:localhost:8080")
public class UserRegistrationController {
    private JwtUserRepository jwtUserRepository;
    private PasswordEncoder passwordEncoder;



    @Autowired
    public UserRegistrationController(JwtUserRepository jwtUserRepository,
                                          PasswordEncoder   passwordEncoder) {
        this.jwtUserRepository = jwtUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/adduser")
    public ResponseEntity<Void> createUser(@RequestBody JwtUserDetails userDetails){
             userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        System.out.println("Output" + userDetails.toString());
             JwtUserDetails createdUser = this.jwtUserRepository.save(userDetails);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }


}
