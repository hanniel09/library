package com.hanniel.library.controllers;

import com.hanniel.library.dtos.UserDTO;
import com.hanniel.library.models.UserModel;
import com.hanniel.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserModel>> getUsers(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserDTO data){
        return new ResponseEntity<>(userService.createUser(data), HttpStatus.CREATED);
    }
}
