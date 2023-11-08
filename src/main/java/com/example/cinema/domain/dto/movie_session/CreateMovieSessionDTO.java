package com.example.cinema.domain.dto.movie_session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateMovieSessionDTO {

    private String data;

    private int time;

    private Long movie_id;

    private Long hall_id;

    private List<Long> ticketIdList;

}
