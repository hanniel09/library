package com.hanniel.library.services;

import com.hanniel.library.dtos.UserDTO;
import com.hanniel.library.models.UserModel;
import com.hanniel.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserModel> getUser(){
        return userRepository.findAll();
    }

    public UserModel createUser(UserDTO data){
        UserModel user = new UserModel(data);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String passwordCrypt = bcrypt.encode(user.getPassword());
        user.setPassword(passwordCrypt);
        return userRepository.save(user);
    }
}
