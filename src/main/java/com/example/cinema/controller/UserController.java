package com.example.cinema.controller;

import com.example.cinema.domain.data.User;
import com.example.cinema.domain.dto.user.CreateUserDTO;
import com.example.cinema.domain.dto.user.UpdateUserDTO;
import com.example.cinema.domain.dto.user.UserDTO;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("one-user/{id}")
    public UserDTO getUser(@PathVariable Long id ){
        return userService.getById(id);
    }

    @PostMapping("/add-user")
    public UserDTO create(@RequestBody CreateUserDTO createUserDTO){
        return userService.create(createUserDTO);
    }

    @PutMapping("/edit-user/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO){
        return userService.update(id, updateUserDTO);
    }
    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Long id){
         userService.delete(id);
    }


}
