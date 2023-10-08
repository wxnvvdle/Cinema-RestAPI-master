package com.example.cinema.domain.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateTicketDTO {

    private int row;

    private int seat;

    private double price;

    private boolean status;

    private Long movieId;

}
