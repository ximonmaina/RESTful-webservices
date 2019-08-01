package com.learnrest.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        for(int i = 0; i<=10; i++) {
//            String encodedString = encoder.encode("simon1234");
//            System.out.println(encodedString);
//        }
        long id = 0;
        Long id2 = null;
        checkIfNull(id);
        checkIfNull(id2);



    }
    public static void checkIfNull(Long isId) {
        Long labId = isId;
        if (labId != null) {
            System.out.println("not null");
        }else if (labId == null) {
            System.out.println("null");
        }
    }
}
