package com.example.demo.user;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewUser(User newUser) {
        Optional<User> userOptional = userRepository.findUserByEmail(newUser.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        userRepository.save(newUser);
        System.out.println(newUser);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("User with id of " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String newName, String newEmail) {

        User foundUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id of " + id + " does not exist"));

        if (newName != null && !Objects.equals(newName, foundUser.getName())) {
            foundUser.setName(newName);
        }

        if (newEmail != null && userRepository.findUserByEmail(newEmail).isEmpty() && !Objects.equals(newEmail, foundUser.getEmail())) {
            foundUser.setEmail(newEmail);
        }
    }
}
