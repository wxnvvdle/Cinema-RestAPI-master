package com.example.cinema.domain.dto.movie_session;

import com.example.cinema.domain.dto.hall.HallDTO;
import com.example.cinema.domain.dto.movie.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchMovieSessionDTO {

    private Date data;

    private int time;

    private Long movie_id;

    private Long hall_id;

}
