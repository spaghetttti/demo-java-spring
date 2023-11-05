package com.example.demo.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
//        return List.of(new User(1L, "Alises",  "alises@gmail.com", LocalDate.of(2000, Month.AUGUST, 3), 19));
        return userRepository.findAll();
    }
}
