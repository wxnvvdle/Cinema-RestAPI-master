package com.example.cinema.service.Impl;


import com.example.cinema.domain.dto.hall.HallDTO;
import com.example.cinema.domain.mapper.HallMapper;
import com.example.cinema.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private HallMapper hallMapper;

    public HallDTO getById(Long id) {
        return hallMapper.toDto(hallRepository.getById(id));
    }

    public List<HallDTO> getAll() {
        return hallMapper.ListToDto(hallRepository.findAll());
    }

}
