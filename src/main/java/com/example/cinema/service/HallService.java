package com.example.cinema.service;

import com.example.cinema.domain.dto.hall.HallDTO;

import java.util.List;

public interface HallService {

    List<HallDTO> findAll();

    HallDTO getById(Long id);

}
