package com.example.demo.controller.repository;

import com.example.demo.controller.repository.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public Optional<UserEntity> findByFirstName(String firstName);
    public Optional<UserEntity> findByMiddleName(String middleName);
    public Optional<UserEntity> findByLastName(String lastName);

}
