package com.ufps.edu.co.backendInmobiliaria.application.service;

import com.ufps.edu.co.backendInmobiliaria.application.dto.UserDTO;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.User;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    //find user by id
    public UserDTO findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new RuntimeException("User hasn't exist");
        else {
            return UserDTO.builder().email(user.get().getEmail()).name(user.get().getName()).lastName(user.get().getLastName()).build();
        }
    }

    //Get a list with user
    public String getAllUser(){
        return userRepository.findAll().stream().map(User::getName).toList().toString();
    }

    //Get user by email
    public UserDTO getUserByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) throw new RuntimeException("Email invalid");
        else {
            return UserDTO.builder().email(user.get().getEmail()).name(user.get().getName()).lastName(user.get().getLastName()).build();
        }
    }

    //update User with id
    public String updateUser(Integer id, User updatedUser) {
        //Verify if exist user by id
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // verify if the attribute is empty and update
        if (updatedUser.getName() != null) {
            existingUser.setName(updatedUser.getName());
        }
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPassword() != null) {
            //Encrypt password


            existingUser.setPassword(updatedUser.getPassword());
        }

        // save existing user
        userRepository.save(existingUser);
        return "User has been updated successfully";
    }

    //Get userName by email
    public String getNameByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) throw new RuntimeException("User doesn't exists");
        return user.get().getName();
    }

}