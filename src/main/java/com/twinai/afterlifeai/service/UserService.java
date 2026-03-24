package com.twinai.afterlifeai.service;

import com.twinai.afterlifeai.model.User;
import com.twinai.afterlifeai.exception.UserNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    // 🔹 Static data loaded at startup
    @PostConstruct
    public void initData() {
        users.add(new User(1L, "Alice", 25));
        users.add(new User(2L, "Bob", 30));
        users.add(new User(3L, "Charlie", 22));
    }

    // CREATE
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    // READ ALL
    public List<User> getAllUsers() {
        return users;
    }

    // READ ONE
    public User getUserById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    // UPDATE
    public User updateUser(Long id, User newUser) {
        User user = getUserById(id);
        user.setName(newUser.getName());
        user.setAge(newUser.getAge());
        return user;
    }

    // DELETE
    public void deleteUser(Long id) {
        User user = getUserById(id);
        users.remove(user);
    }
}