package com.learnrest.rest.basic;

import lombok.Data;

@Data
public class AuthenticationBean {
    private final String message;

    public AuthenticationBean(String message) {
        this.message = message;
    }
}
