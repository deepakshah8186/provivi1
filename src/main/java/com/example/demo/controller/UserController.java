package com.example.demo.controller;

import com.example.demo.error.CustomException;
import com.example.demo.error.ErrorResponse;
import com.example.demo.error.NotFoundException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "users", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/first/{fName}")
    public ResponseEntity getAFirstName(@PathVariable(required = true) String fName) {
        return ResponseEntity.ok(userService.getUserByFirstName(fName));
    }
    @GetMapping("/middle/{mName}")
    public ResponseEntity getAMiddleName(@PathVariable(required = true) String mName) {
        return ResponseEntity.ok(userService.getUserByMiddleName(mName));
    }
    @GetMapping("/last/{lName}")
    public ResponseEntity getALastName(@PathVariable(required = true) String lName)  {
        return ResponseEntity.ok(userService.getUserByLastName(lName));
    }

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handle(CustomException e) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(e.getMessage());
        return error;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(NotFoundException e) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(e.getMessage());
        return error;
    }

}
