package com.example.cinema.domain.mapper;

import com.example.cinema.domain.data.Theater;
import com.example.cinema.domain.dto.theater.TheaterDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TheaterMapper {

    public TheaterDTO toDto(Theater theater) {
        TheaterDTO theaterDTO = new TheaterDTO();

        theaterDTO.setId(theater.getId());
        theaterDTO.setName(theater.getName());
        theaterDTO.setAddress(theater.getAddress());

        List<Long> hallIdList = new ArrayList<>();

        theater.getHallList().forEach(hall -> hallIdList.add(hall.getId()));
        theaterDTO.setHallIds(hallIdList);

        return theaterDTO;
    }

    public List<TheaterDTO> listToDto(List<Theater> theaterList) {
        List<TheaterDTO> theaterDTOList = new ArrayList<>();

        theaterList.forEach(theater -> theaterDTOList.add(toDto(theater)));

        return theaterDTOList;
    }
}
