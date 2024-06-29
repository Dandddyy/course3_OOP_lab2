package com.hbet.service;

import com.hbet.dto.UserCreateDTO;
import com.hbet.dto.UserDTO;
import com.hbet.entity.User;
import com.hbet.mapper.UserMapper;
import com.hbet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(mapper::toUserDTO).toList();
    }

    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        String encodedPassword = passwordEncoder.encode(userCreateDTO.getPassword());
        userCreateDTO.setPassword(encodedPassword);
        User user = mapper.fromUserCreate(userCreateDTO);
        user.setRole("user");
        User createdItem = userRepository.save(user);
        return mapper.toUserDTO(createdItem);
    }
}