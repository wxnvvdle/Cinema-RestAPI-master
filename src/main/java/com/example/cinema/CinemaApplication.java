package com.example.cinema;

import com.example.cinema.repository.MovieRepository;
import com.example.cinema.repository.TicketRepository;
import com.example.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);

    }

/*    @PostConstruct
    public void initialize() {
        List<Movie> movieList = new ArrayList<>();

        Movie movie1 = new Movie("NoTimeToDIE", "Boring", "Horror");
        Movie movie2 = new Movie("Jeep-perScraper 2", "EXCITING", "Comedy");

        movieList.add(movie1);
        movieList.add(movie2);

        movieRepository.saveAll(movieList);


        List<Ticket> tickets = new ArrayList<>();

        Ticket ticket1 = new Ticket(1, 1, 15.0, movie1);
        Ticket ticket2 = new Ticket(1, 2, 15.0, movie1);
        Ticket ticket3 = new Ticket(1, 3, 15.0, movie1);
        Ticket ticket4 = new Ticket(2, 4, 15.0, movie1);
        Ticket ticket5 = new Ticket(2, 5, 15.0, movie1);

        Ticket ticket6 = new Ticket(1, 1, 20.0, movie2);
        Ticket ticket7 = new Ticket(1, 2, 20.0, movie2);
        Ticket ticket8 = new Ticket(1, 3, 20.0, movie2);
        Ticket ticket9 = new Ticket(2, 4, 20.0, movie2);
        Ticket ticket10 = new Ticket(2, 5, 20.0, movie2);

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

        ticketRepository.saveAll(tickets);


        List<User> userList = new ArrayList<>();

        User user1 = new User(1L, "Peter", "Parker", 17, "Massachuchets", null);
        User user2 = new User(2L, "Hannah", "Chapmenova", 21, "Wonderwill", null);

        userList.add(user1);
        userList.add(user2);

        userRepository.saveAll(userList);
        }*/



}
