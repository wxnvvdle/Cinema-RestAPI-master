package com.example.cinema.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserDTO {

    private String firstName;

    private String lastName;

    private int age;

    private String city;

    private List<Long> ticketIds;

}
