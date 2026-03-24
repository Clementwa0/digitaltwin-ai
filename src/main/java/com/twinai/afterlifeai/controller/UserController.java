package com.twinai.afterlifeai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twinai.afterlifeai.model.User;
import com.twinai.afterlifeai.service.UserService;

import jakarta.validation.Valid;

/**
 * REST Controller that handles HTTP requests related to User.
 * 
 * @RestController combines @Controller and @ResponseBody,
 *                 meaning all methods return data (JSON/XML) instead of views.
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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Endpoint to search for a name. This demonstrates how to use @RequestParam to
    // @requestparam is used to extract query parameters from the URL, allowing
    // clients to pass data in the request URL.
    @GetMapping("/search")
    public String search(@RequestParam String name) {
        return "Searching for: " + name;
    }

    /**
     * Endpoint to create a new User.
     * Accepts a JSON request body and converts it into a User object.
     *
     * @param user the user data sent in the request body
     * @return the created user (simulated)
     */
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

}