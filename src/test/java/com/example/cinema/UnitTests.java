package com.example.cinema;

import com.example.cinema.domain.data.Movie;
import com.example.cinema.domain.data.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;


public class UnitTests {

    @Test
    public void createMovieEntityTest() {
        Movie movie = new Movie(1L, "test", "test description", "action");

        Assertions.assertEquals(1, movie.getId());
        Assertions.assertEquals("test", movie.getTitle());
        Assertions.assertEquals("test description", movie.getDescription());
        Assertions.assertEquals("action", movie.getGenre());
    }

    @Test
    public void createOrderTicketEntityTest() {
        Movie movie = new Movie(1L, "test", "test description", "action");
        Ticket ticket = new Ticket(1L, 6, 3, 114.50, movie);

        Assertions.assertEquals(1, ticket.getId());
        Assertions.assertEquals(6, ticket.getRowPlace());
        Assertions.assertEquals(3, ticket.getSeat());
        Assertions.assertEquals(114.50, ticket.getPrice());
    }

    @Test
    public void setMovieEntityToOrderTicketTest() {
        Movie movie = new Movie(1L, "test", "test description", "action");
        Ticket ticket = new Ticket(1L, 6, 3, 114.50, movie);

        Assertions.assertEquals(movie.getId(), ticket.getMovie().getId());
    }

    @Test
    public void setTicketEntityToMovieTest() {
        Movie movie = new Movie(1L, "test", "test description", "action");

        Ticket ticket = new Ticket(1L, 6, 3, 114.50, movie );

        Assertions.assertEquals(movie.getTickets().stream().findFirst().get().getId(), ticket.getId());
    }

}
