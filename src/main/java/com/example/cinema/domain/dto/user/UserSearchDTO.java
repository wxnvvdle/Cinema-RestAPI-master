package com.example.cinema.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSearchDTO {

    private String firstName;

    private String lastName;

    private int age;

    private String city;

    private Long movieId;

}
