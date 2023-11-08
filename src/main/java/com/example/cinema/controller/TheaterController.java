package com.example.cinema.controller;

//getAll and getById

import com.example.cinema.domain.data.Theater;
import com.example.cinema.domain.dto.theater.TheaterDTO;
import com.example.cinema.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheaterController {

    public TheaterService theaterService;


    @GetMapping("/theaters")
    public List<TheaterDTO> getAll() {
        return theaterService.findAll();
    }

    @GetMapping("/theater/{id}")
    public TheaterDTO getById(@PathVariable Long id) {
        return theaterService.getById(id);
    }

}
