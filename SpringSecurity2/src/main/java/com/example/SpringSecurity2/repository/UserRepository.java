package com.example.SpringSecurity2.repository;

import com.example.SpringSecurity2.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
 @EntityGraph(attributePaths = "roles")
 Optional<User>findByUsername(String username);
}
