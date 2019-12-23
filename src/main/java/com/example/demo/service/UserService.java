package com.example.demo.service;

import com.example.demo.controller.repository.UserRepository;
import com.example.demo.controller.repository.model.UserEntity;
import com.example.demo.error.NotFoundException;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public UserEntity createUser(User user) {
        return repository.save(toEntity(user));
    }

    public UserEntity getUserByFirstName(String firstName) throws NotFoundException {
        Optional<UserEntity> user = repository.findByFirstName(firstName);
        if (!user.isPresent()) {
            throw new NotFoundException("Couldn't find user with first name: " + firstName);
        }
        return user.get();
    }

    public UserEntity getUserByMiddleName(String middleName) {
        Optional<UserEntity> user = repository.findByMiddleName(middleName);
        if (!user.isPresent()) {
            throw new NotFoundException("Couldn't find user with middle name: " + middleName);
        }
        return user.get();
    }

    public UserEntity getUserByLastName(String lastName) {
        Optional<UserEntity> user = repository.findByLastName(lastName);
        if (!user.isPresent()) {
            throw new NotFoundException("Couldn't find user with last name: " + lastName);
        }
        return user.get();
    }

    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setFirstName(user.getFirstName());
        entity.setMiddleName(user.getMiddleName());
        entity.setLastName(user.getLastName());
        return entity;
    }
}
