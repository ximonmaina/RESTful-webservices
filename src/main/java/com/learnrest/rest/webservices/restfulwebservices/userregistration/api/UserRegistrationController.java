package com.learnrest.rest.webservices.restfulwebservices.userregistration.api;

import com.learnrest.rest.webservices.restfulwebservices.userregistration.domain.UserData;
import com.learnrest.rest.webservices.restfulwebservices.userregistration.repository.UserDataRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/register")
@CrossOrigin("http://localhost:4200")
public class UserRegistrationController {
    private UserDataRepository userRepo;
    private PasswordEncoder passwordEncoder;



    @Autowired
    public UserRegistrationController(UserDataRepository userRepo,
                                          PasswordEncoder   passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/getusers")
    public Iterable<UserData> getAllUsers() {
        return this.userRepo.findAll();
    }

    @GetMapping("/getuser/{id}")
    public UserData getUser(@PathVariable long id) {
        Optional<UserData> findUser = this.userRepo.findUserDataById(id);

        if (findUser.isPresent()) {
            return findUser.get();
        }
        return null;


    }

    @GetMapping("/getrole/{username}")
    public UserData getUserRole(@PathVariable String username) {
        Optional<UserData> findUserWithRole = this.userRepo.findByUserName(username);

        if (findUserWithRole.isPresent()) {
            return findUserWithRole.get();
        }
        return null;
    }

    @PostMapping("/adduser")
    public ResponseEntity<Void> createUser(@RequestBody UserData userDetails){
             userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
             userDetails.setDisplayName(userDetails.getFirstName() + ' ' + userDetails.getLastName());
             userDetails.setJoinDate(new Date());
//        System.out.println("Output" + userDetails.toString());
             UserData createdUser = this.userRepo.save(userDetails);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @PatchMapping("/updateuser")
    public ResponseEntity<UserData> updateUser(@RequestBody UserData userData){
        UserData getUser = this.userRepo.findById(userData.getId());
        if (userData.getPassword() == getUser.getPassword()) {
            userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        }

        userData.setDisplayName(userData.getFirstName() + ' ' + userData.getLastName());
        userData.setJoinDate(new Date());
        System.out.println("Output" + userData.toString());
        UserData updatedUser = this.userRepo.save(userData);

        return new ResponseEntity<UserData>(userData, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        System.out.println("id is" + id);
         this.userRepo.deleteById(id);

         return ResponseEntity.noContent().build();

    }


}
