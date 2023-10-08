package com.example.cinema.domain.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchTicketDTO {

    private Integer row;

    private Integer seat;

    private Double minPrice;

    private Double maxPrice;

    private boolean status;

    private Long movieId;

}
