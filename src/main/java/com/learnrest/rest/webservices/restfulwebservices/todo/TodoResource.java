package com.learnrest.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private TodoHardCodedService  todoHardCodedService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
     return this.todoHardCodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username ,@PathVariable long id){
     return this.todoHardCodedService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
       Todo todo =  this.todoHardCodedService.deleteById(id);
       if (todo != null) {
           // if successful
           return ResponseEntity.noContent().build();
       }
       // if it fails
       return ResponseEntity.notFound().build();

    }

    @PutMapping("/users/{username}/todos/{todo_id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long todo_id,
                                           @RequestBody Todo todo) {
        Todo updatedTodo = this.todoHardCodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username,  @RequestBody Todo todo) {
        Todo createdTodo = this.todoHardCodedService.save(todo);

        // Location
        // Get current resource url
        // /{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();

        // returns a status of created and a uri
        return ResponseEntity.created(uri).build();
    }



}
