package com.example.cinema.domain.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hall {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "seats")
    private int seats;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "cinemaHall")
    private List<MovieSession> movieSessionList;

}
