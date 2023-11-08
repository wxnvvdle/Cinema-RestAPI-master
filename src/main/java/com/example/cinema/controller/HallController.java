package com.example.cinema.controller;

//getAll and getById

import com.example.cinema.domain.data.Hall;
import com.example.cinema.domain.dto.hall.HallDTO;
import com.example.cinema.service.HallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HallController {

    private HallService hallService;

    @GetMapping("/halls")
    public List<HallDTO> getAll() {
        return hallService.findAll();
    }

    @GetMapping("/hall/{id}")
    public HallDTO getHall(@PathVariable Long id) {
        return hallService.getById(id);
    }

}
