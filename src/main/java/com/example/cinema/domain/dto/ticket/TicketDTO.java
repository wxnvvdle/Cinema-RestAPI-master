package com.example.cinema.domain.dto.ticket;

import com.example.cinema.domain.dto.movie.MovieDTO;
import lombok.Data;

@Data
public class TicketDTO {


    private Long id;

    private int row;

    private int seat;

    private double price;

    private boolean status;

    private MovieDTO movie;

}
