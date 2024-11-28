package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.controller;

import com.ufps.edu.co.backendInmobiliaria.application.dto.UserDTO;
import com.ufps.edu.co.backendInmobiliaria.application.service.UserService;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Get All User
    @GetMapping
    public ResponseEntity<String> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    //Find user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }

    //update user by id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    //Get user by email
    //Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<String> getUserByEmail( @PathVariable String email){
        System.out.println(email);
        return ResponseEntity.ok(userService.getNameByEmail(email));
    }

}