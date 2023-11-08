package com.example.cinema.service;

import com.example.cinema.domain.dto.theater.TheaterDTO;

import java.util.List;

public interface TheaterService {

    List<TheaterDTO> findAll();

    TheaterDTO getById(Long id);

}
