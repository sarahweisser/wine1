package com.wineApi.wine1.controllers;

import com.wineApi.wine1.exceptions.LoginFailureException;
import com.wineApi.wine1.exceptions.UserNotFoundException;
import com.wineApi.wine1.exceptions.ValidationMessages;
import com.wineApi.wine1.models.User;
import com.wineApi.wine1.repositories.UserJpaRepository;
import com.wineApi.wine1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    Iterable<User> findAllUsers() {
        return userJpaRepository.findAll();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<Optional<User>> findUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userJpaRepository.findById(id), HttpStatus.OK);
        } catch (UserNotFoundException unfe) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ValidationMessages.USER_NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, ValidationMessages.MISC_ERROR);
        }
    }

    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userJpaRepository.saveAndFlush(user), HttpStatus.OK);
    }

    @PostMapping("/users/login")
    ResponseEntity<User> loginUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.processUserLogin(user), HttpStatus.OK);
        } catch (UserNotFoundException unfe) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ValidationMessages.USER_NOT_FOUND);
        } catch (LoginFailureException lfe) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, ValidationMessages.INCORRECT_PASS);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, ValidationMessages.MISC_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        try {
            Optional<User> existingUser = userJpaRepository.findById(user.getUserId());

            if (existingUser.isPresent()) {
                return new ResponseEntity<>(userJpaRepository.saveAndFlush(user), HttpStatus.OK);
            } else {
                throw new UserNotFoundException();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, ValidationMessages.MISC_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userJpaRepository.deleteById(id);
    }
}