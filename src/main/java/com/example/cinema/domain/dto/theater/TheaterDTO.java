package com.example.cinema.domain.dto.theater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TheaterDTO {

    public Long id;

    public String name;

    public String address;

    public List<Long> hallIds;

}
