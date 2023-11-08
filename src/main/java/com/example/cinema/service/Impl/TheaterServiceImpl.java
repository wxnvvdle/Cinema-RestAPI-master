package com.example.cinema.service.Impl;


import com.example.cinema.domain.dto.theater.TheaterDTO;
import com.example.cinema.domain.mapper.TheaterMapper;
import com.example.cinema.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl {

    @Autowired
    private TheaterMapper theaterMapper;

    @Autowired
    private TheaterRepository theaterRepository;

    public TheaterDTO getById(Long id) {
        return theaterMapper.toDto(theaterRepository.getById(id));
    }

    public List<TheaterDTO> getAll() {
        return theaterMapper.listToDto(theaterRepository.findAll());
    }
}
