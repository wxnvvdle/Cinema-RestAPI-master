package com.example.cinema.service;

import com.example.cinema.domain.dto.user.CreateUserDTO;
import com.example.cinema.domain.dto.user.UpdateUserDTO;
import com.example.cinema.domain.dto.user.UserDTO;

public interface UserService {

    UserDTO getById(Long id);

    UserDTO create(CreateUserDTO createUserDTO);

    UserDTO update(Long id, UpdateUserDTO updateUserDTO);

    void delete(Long id);


}
