package com.learnrest.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

    static Integer count = 0;
    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        for(int i = 0; i<=10; i++) {
//            String encodedString = encoder.encode("simon1234");
//            System.out.println(encodedString);
//        }
//        long id = 0;
//        Long id2 = null;
//        checkIfNull(id);
//        checkIfNull(id2);
//
//
//
//    }
//    public static void checkIfNull(Long isId) {
//        Long labId = isId;
//        if (labId != null) {
//            System.out.println("not null");
//        }else if (labId == null) {
//            System.out.println("null");
//        }
        System.out.println(getEmployeeIdBy("simon","maina","kariuki"));
        System.out.println(getEmployeeIdBy("John","kariuki","Maina"));
        System.out.println(getEmployeeIdBy("Duncan","Nandwa","Okeno"));
        System.out.println(getEmployeeIdBy("charity","njeri","warui"));
        System.out.println(getEmployeeIdBy("benedict","joe","njoroge"));

    }

    public static String getEmployeeIdBy(String firstName, String middleName, String lastName) {
        String res1 = firstName.substring(0, 3).toUpperCase();
        String res2 = middleName.isEmpty() ? "0" : middleName.substring(0, 1).toUpperCase();
        String res3 = lastName.substring(0, 3).toUpperCase();
        String res4 = res1 + res2 + res3;
        String res5 = count.toString().length() == 1 ? ("00" + count):
                 count.toString().length() == 2 ? ("0" + count) : count.toString();
        count = count + 1;
        String finalResult = res4 + res5;
        return finalResult;
    }
}
