package com.example.cinema.service.Impl;

import com.example.cinema.domain.data.Hall;
import com.example.cinema.domain.data.Movie;
import com.example.cinema.domain.data.MovieSession;
import com.example.cinema.domain.data.Ticket;
import com.example.cinema.domain.dto.movie_session.CreateMovieSessionDTO;
import com.example.cinema.domain.dto.movie_session.MovieSessionDTO;
import com.example.cinema.domain.dto.movie_session.UpdateMovieSessionDTO;
import com.example.cinema.domain.mapper.MovieSessionMapper;
import com.example.cinema.repository.HallRepository;
import com.example.cinema.repository.MovieRepository;
import com.example.cinema.repository.MovieSessionRepository;
import com.example.cinema.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieSessionServiceImpl {

    @Autowired
    private MovieSessionRepository movieSessionRepository;

    @Autowired
    private MovieSessionMapper movieSessionMapper;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private HallRepository hallRepository;

    public MovieSessionDTO getById(Long id) {
        return movieSessionMapper.toDto(movieSessionRepository.getById(id));
    }

    public MovieSessionDTO create(CreateMovieSessionDTO createMovieSessionDTO) {
        Movie movie = movieRepository.getById(createMovieSessionDTO.getMovie_id());

        Hall hall = hallRepository.getById(createMovieSessionDTO.getHall_id());

        List<Ticket> ticketList = ticketRepository.findAllById(createMovieSessionDTO.getTicketIdList());

        MovieSession movieSession = movieSessionMapper.createEntity(createMovieSessionDTO, movie, hall, ticketList);
        movieSessionRepository.save(movieSession);

        return movieSessionMapper.toDto(movieSession);
    }

    public MovieSessionDTO update(Long id, UpdateMovieSessionDTO updateMovieSessionDTO) {
        MovieSession movieSession = movieSessionRepository.getById(id);

        Movie movie = movieRepository.getById(updateMovieSessionDTO.getMovie_id());

        Hall hall = hallRepository.getById(updateMovieSessionDTO.getHall_id());

        List<Ticket> ticketList = ticketRepository.findAllById(updateMovieSessionDTO.getTicketIdList());

        movieSession = movieSessionMapper.updateEntity(updateMovieSessionDTO, movie, hall, ticketList, movieSession);
        movieSessionRepository.save(movieSession);

        return movieSessionMapper.toDto(movieSession);
    }

}
