package com.learnrest.rest.webservices.restfulwebservices.tokenstringconstants;

public enum TokenString {
    TOKEN_STRING("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaW1vbiIsImV4cCI6MTU2NjcyOTE3NywiaWF0IjoxNTY2MTI0Mzc3fQ.gzI1K0CwPZC4wuJB4BUSH8l6mn3255mYoRwpkpD6aMjTr2Ijg7ra6fpSTB_PAklnIPsrXy6k-_FpzIUyY4KRcw");

    private String tokenString;

    TokenString(String s) {
        this.tokenString = s;
    }

    public String getTokenString() {
        return tokenString;
    }

}
