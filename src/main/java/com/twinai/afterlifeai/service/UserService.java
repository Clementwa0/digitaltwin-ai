package com.twinai.afterlifeai.service;

import org.springframework.stereotype.Service;
import com.twinai.afterlifeai.model.User;

/**
 * Service layer class responsible for handling business logic related to User.
 * 
 * The @Service annotation marks this class as a Spring-managed service component,
 * allowing it to be injected into controllers or other services.
 */
@Service
public class UserService {
    
    /**
     * Returns a simple message.
     * This method demonstrates basic service functionality.
     *
     * @return a greeting message from the service layer
     */
    public String getMessage() {
        return "Hello from Service Layer";
    }

    /**
     * Creates and returns a sample User object.
     * In a real application, this data would typically come from a database.
     *
     * @return a User object with predefined values
     */
    public User getUser() {
        return new User("Clement", 22);
    }

    public User getUser(int id) {
        // In a real application, you would fetch the user from a database using the id
        return new User("User" + id, 20 + id); // Simulating different users based on id
    }

    /**
     * Accepts a User object and returns it.
     * In a real-world scenario, this method would handle saving the user to a database.
     *
     * @param user the user object to be created
     * @return the same user object (simulating a save operation)
     */
    public User createUser(User user) {
        // In real apps, you would persist the user to a database here
        return user;
    }
}