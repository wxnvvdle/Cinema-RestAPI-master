package com.example.cinema.domain.dto.movie_session;

import com.example.cinema.domain.data.Ticket;
import com.example.cinema.domain.dto.hall.HallDTO;
import com.example.cinema.domain.dto.movie.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieSessionDTO {

    public  Long id;

    private String data;

    private int time;

    private MovieDTO movie;

    private HallDTO hall;

    private List<Ticket> ticketList;

}
