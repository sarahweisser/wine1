package com.wineApi.wine1.services;

import com.wineApi.wine1.exceptions.LoginFailureException;
import com.wineApi.wine1.exceptions.UserNotFoundException;
import com.wineApi.wine1.models.User;
import com.wineApi.wine1.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserJpaRepository userJpaRepository;

    public User processUserLogin(User user) {
        System.out.println("In processUserLogin");

        // TODO validate input

        Optional<User> existingUser = userJpaRepository.findUsersByUserName(user.getUserName());
        if (existingUser.isPresent()) {
            if (existingUser.get().getUserPassword().equals(user.getUserPassword())) {
                return user;
            } else throw new LoginFailureException();
        } else throw new UserNotFoundException();
    }
}
