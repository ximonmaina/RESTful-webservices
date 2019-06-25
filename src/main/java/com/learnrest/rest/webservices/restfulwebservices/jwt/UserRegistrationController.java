package com.learnrest.rest.webservices.restfulwebservices.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/register")
@CrossOrigin("http:localhost:8080")
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
        Optional<UserData> findUser = this.userRepo.findById(id);

        if (findUser.isPresent()) {
            return findUser.get();
        }
        return null;


    }

    @PostMapping("/adduser")
    public ResponseEntity<Void> createUser(@RequestBody UserData userDetails){
             userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        System.out.println("Output" + userDetails.toString());
             UserData createdUser = this.userRepo.save(userDetails);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/updateuser")
    public ResponseEntity<UserData> updateTodo(@RequestBody UserData userData){
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
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
