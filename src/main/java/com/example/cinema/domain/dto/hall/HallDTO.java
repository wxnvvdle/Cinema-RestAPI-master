package com.example.cinema.domain.dto.hall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HallDTO {

    public Long id;

    public String name;

    public int seats;

    public Long theaterId;

}
