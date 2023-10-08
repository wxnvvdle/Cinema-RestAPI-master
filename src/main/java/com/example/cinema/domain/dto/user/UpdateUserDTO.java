package com.example.cinema.domain.dto.user;

import com.example.cinema.domain.dto.ticket.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserDTO {

    private String firstName;

    private String lastName;

    private int age;

    private String city;

    private List<Long> ticketIds;

}
