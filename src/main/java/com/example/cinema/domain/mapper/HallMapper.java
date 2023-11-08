package com.example.cinema.domain.mapper;

import com.example.cinema.domain.data.Hall;
import com.example.cinema.domain.dto.hall.HallDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HallMapper {

    public HallDTO toDto(Hall hall) {
        HallDTO hallDTO = new HallDTO();

        hallDTO.setId(hall.getId());
        hallDTO.setName(hall.getName());
        hallDTO.setSeats(hall.getSeats());
        hallDTO.setTheaterId(hall.getTheater().getId());

        return hallDTO;
    }

    public List<HallDTO> ListToDto(List<Hall> hallList) {
        List<HallDTO> hallDTOList = new ArrayList<>();

        hallList.forEach(hall -> hallDTOList.add(toDto(hall)));

        return hallDTOList;
    }

}
