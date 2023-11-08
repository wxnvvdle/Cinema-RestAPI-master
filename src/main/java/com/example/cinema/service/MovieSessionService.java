package com.example.cinema.service;

import com.example.cinema.domain.dto.movie_session.MovieSessionDTO;
import com.example.cinema.domain.dto.user.CreateUserDTO;
import com.example.cinema.domain.dto.user.UpdateUserDTO;
import com.example.cinema.domain.dto.user.UserDTO;

public interface MovieSessionService {


    MovieSessionDTO getById(Long id);

    MovieSessionDTO create(CreateUserDTO createUserDTO);

    MovieSessionDTO update(Long id, UpdateUserDTO updateUserDTO);

    void delete(Long id);
}
