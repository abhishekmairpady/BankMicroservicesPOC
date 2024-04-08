package com.example.users_service.repository;

import com.example.users_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);

    Optional<List<User>> findByClientId(int clientId);
}
