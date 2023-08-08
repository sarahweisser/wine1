package com.wineApi.wine1.repositories;

import com.wineApi.wine1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findUsersByUserName(String userName);
}
