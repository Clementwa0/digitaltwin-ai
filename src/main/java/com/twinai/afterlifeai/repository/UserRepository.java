package com.twinai.afterlifeai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.twinai.afterlifeai.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}