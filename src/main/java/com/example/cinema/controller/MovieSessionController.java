package com.example.cinema.controller;

// crud softDelete(база даных не удаляет табличку если у неё есть форейн кей в другую табличку а просто делает active=0(неактивной))
//getAll(будет ожидать либо movie_id либо hall_id и возвращать только активные)

import com.example.cinema.domain.data.MovieSession;
import com.example.cinema.domain.dto.movie_session.MovieSessionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieSessionController {

    @GetMapping
    public MovieSessionDTO getById(@PathVariable Long id) {
        return movieSessionService.getById(id);
    }

    @PutMapping
    public MovieSessionDTO editSession(@PathVariable Long id, UpdateMovieSessionDto updateMovieSessionDto) {
        return
    }

}
