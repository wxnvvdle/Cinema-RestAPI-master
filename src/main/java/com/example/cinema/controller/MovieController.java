package com.example.cinema.controller;

import com.example.cinema.domain.dto.movie.CreateMovieDTO;
import com.example.cinema.domain.dto.movie.MovieDTO;
import com.example.cinema.domain.dto.movie.SearchMovieDTO;
import com.example.cinema.domain.dto.movie.UpdateMovieDTO;
import com.example.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add-movie")
    public MovieDTO create(@RequestBody CreateMovieDTO createMovieDTO) {
        return movieService.create(createMovieDTO);
    }

    @GetMapping("/all")
    public List<MovieDTO> getAll() {
        return movieService.findAll();
    }

    @GetMapping("one-movie/{id}")
    public MovieDTO getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @GetMapping("/search-by-specification")
    public List<MovieDTO> searchBySpecification(@RequestBody SearchMovieDTO searchMovieDTO) {
        return movieService.searchBySpecification(searchMovieDTO);
    }

    @PutMapping("/edit/{id}")
    public MovieDTO update(@PathVariable Long id, @RequestBody UpdateMovieDTO updateMovieDTO) {
        return movieService.update(id, updateMovieDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

}
