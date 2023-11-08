package com.example.cinema.domain.mapper;

import com.example.cinema.domain.data.Hall;
import com.example.cinema.domain.data.Movie;
import com.example.cinema.domain.data.MovieSession;
import com.example.cinema.domain.data.Ticket;
import com.example.cinema.domain.dto.movie_session.CreateMovieSessionDTO;
import com.example.cinema.domain.dto.movie_session.MovieSessionDTO;
import com.example.cinema.domain.dto.movie_session.UpdateMovieSessionDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSessionMapper {

    public MovieSession createEntity(CreateMovieSessionDTO createMovieSessionDTO, Movie movie, Hall hall, List<Ticket> ticketList) {
        MovieSession movieSession = new MovieSession();

        movieSession.setDate(createMovieSessionDTO.getData());
        movieSession.setTime(createMovieSessionDTO.getTime());
        movieSession.setMovie(movie);
        movieSession.setHall(hall);
        movieSession.setTicketList(ticketList);

        return movieSession;
    }

    public MovieSession updateEntity(UpdateMovieSessionDTO updateMovieSessionDTO, Movie movie, Hall hall, List<Ticket> ticketList, MovieSession movieSession) {
        movieSession.setDate(updateMovieSessionDTO.getData());
        movieSession.setTime(updateMovieSessionDTO.getTime());
        movieSession.setMovie(movie);
        movieSession.setHall(hall);
        movieSession.setTicketList(ticketList);

        return movieSession;
    }

    public MovieSessionDTO toDto(MovieSession movieSession) {
        MovieSessionDTO movieSessionDTO = new MovieSessionDTO();

        movieSessionDTO.setId(movieSession.getId());
        movieSessionDTO.setData(movieSession.getDate());
        movieSessionDTO.setTime(movieSession.getTime());
        movieSessionDTO.setMovie(movieSessionDTO.getMovie());
        movieSessionDTO.setHall(movieSessionDTO.getHall());
        movieSessionDTO.setTicketList(movieSession.getTicketList());

        return movieSessionDTO;
    }

    public List<MovieSessionDTO> listToDto(List<MovieSession> movieSessionList) {
        List<MovieSessionDTO> movieSessionDTOList = new ArrayList<>();

        movieSessionList.forEach(movieSession -> movieSessionDTOList.add(toDto(movieSession)));

        return movieSessionDTOList;
    }

}
