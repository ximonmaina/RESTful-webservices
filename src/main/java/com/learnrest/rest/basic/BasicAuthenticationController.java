package com.learnrest.rest.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("You are authenticated");
    }




}
