package com.twinai.afterlifeai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.twinai.afterlifeai.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}