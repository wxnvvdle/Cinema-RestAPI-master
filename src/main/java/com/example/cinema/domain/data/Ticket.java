package com.example.cinema.domain.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "row_place")
    private int rowPlace;

    @Column(name = "seat")
    private int seat;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private boolean status = true;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

    public Ticket(int rowPlace, int seat, double price, Movie movie) {
        this.rowPlace = rowPlace;
        this.seat = seat;
        this.price = price;
        this.movie = movie;
    }

    public Ticket(Long id, int rowPlace, int seat, double price, Movie movie) {
        this.id = id;
        this.rowPlace = rowPlace;
        this.seat = seat;
        this.price = price;
        this.movie = movie;
    }
}
