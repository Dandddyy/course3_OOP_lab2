package com.hbet.controller;

import com.hbet.dto.UserCreateDTO;
import com.hbet.dto.UserDTO;
import com.hbet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> user = userService.getUsers();
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(
            @RequestBody UserCreateDTO userToCreate
    ) {
        UserDTO createdUser = userService.createUser(userToCreate);
        if (createdUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdUser);
    }
}
