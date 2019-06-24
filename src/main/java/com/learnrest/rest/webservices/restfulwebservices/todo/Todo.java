package com.learnrest.rest.webservices.restfulwebservices.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class Todo {

    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;
}
