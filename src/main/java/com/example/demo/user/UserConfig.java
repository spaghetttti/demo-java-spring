package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User alise = new User("Alise", "alises@gmail.com", LocalDate.of(2000, Month.AUGUST, 3));
            User alex = new User("Alex", "Alex@gmail.com", LocalDate.of(2001, Month.APRIL, 6));


            repository.saveAll(List.of(alise, alex));
        };
    }
}
