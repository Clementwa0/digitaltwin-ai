package com.twinai.afterlifeai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twinai.afterlifeai.model.User;
import com.twinai.afterlifeai.service.UserService;

/**
 * REST Controller that handles HTTP requests related to User.
 * 
 * @RestController combines @Controller and @ResponseBody,
 * meaning all methods return data (JSON/XML) instead of views.
 */
@RestController
public class UserController {

    /**
     * Injecting the UserService using Spring's dependency injection.
     * This allows us to use business logic defined in the service layer.
     */
    @Autowired
    private UserService userService;

    /**
     * Simple test endpoint to check if the application is running.
     *
     * @return a greeting message
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    /**
     * Endpoint to fetch a sample User object.
     *
     * @return a User object from the service layer
     */
    @GetMapping("/user")
    public User getUser() {
        return userService.getUser();
    }

    /**
     * Endpoint to create a new User.
     * Accepts a JSON request body and converts it into a User object.
     *
     * @param user the user data sent in the request body
     * @return the created user (simulated)
     */
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Endpoint to return a message from the service layer.
     *
     * @return a string message
     */
    @GetMapping("/message")
    public String message() {
        return userService.getMessage();
    }
}