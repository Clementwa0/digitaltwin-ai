package com.twinai.afterlifeai.model;

public class User {
    
    // Private field to store the user's username
    private String username;
    
    // Private field to store the user's age
    private int age;
    
    // Default constructor - creates a User object with no initial values
    // Required for frameworks like Spring and Hibernate that use reflection
    public User(){}

    // Parameterized constructor - creates a User object with specified username and age
    // @param username the user's username to set
    // @param age the user's age to set
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // Getter method for username
    // @return the user's username
    public String getUsername() {
        return username;
    }
    
    // Setter method for username
    // @param username the username to set
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for age
    // @return the user's age
    public int getAge() {
        return age;
    }
    
    // Setter method for age
    // @param age the age to set
    public void setAge(int age) {
        this.age = age; 
    }

}