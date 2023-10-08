package com.example.cinema.domain.mapper;

import com.example.cinema.domain.data.Ticket;
import com.example.cinema.domain.dto.ticket.CreateTicketDTO;
import com.example.cinema.domain.dto.ticket.TicketDTO;
import com.example.cinema.domain.dto.ticket.UpdateTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketMapper {

    @Autowired
    private MovieMapper movieMapper;

    public Ticket toCreateEntity(CreateTicketDTO createTicketDTO) {
        Ticket ticket = new Ticket();

        ticket.setRowPlace(createTicketDTO.getRow());
        ticket.setSeat(createTicketDTO.getSeat());
        ticket.setPrice(createTicketDTO.getPrice());

        return ticket;
    }

    public Ticket toUpdateEntity(Ticket ticket, UpdateTicketDTO updateTicketDTO) {
        ticket.setRowPlace(updateTicketDTO.getRow());
        ticket.setSeat(updateTicketDTO.getSeat());
        ticket.setPrice(updateTicketDTO.getPrice());
        ticket.setStatus(updateTicketDTO.isStatus());

        return ticket;
    }

    public TicketDTO toDto(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId(ticket.getId());
        ticketDTO.setRow(ticket.getRowPlace());
        ticketDTO.setSeat(ticket.getSeat());
        ticketDTO.setPrice(ticket.getPrice());
        ticketDTO.setMovie(movieMapper.toDto(ticket.getMovie()));
        ticketDTO.setStatus(ticket.isStatus());

        return ticketDTO;
    }

    public List<TicketDTO> toDto(List<Ticket> ticketList) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        ticketList.forEach(orderTicket -> {
            TicketDTO ticketDTO = new TicketDTO();

            ticketDTO.setId(orderTicket.getId());
            ticketDTO.setRow(orderTicket.getRowPlace());
            ticketDTO.setSeat(orderTicket.getSeat());
            ticketDTO.setPrice(orderTicket.getPrice());
            ticketDTO.setMovie(movieMapper.toDto(orderTicket.getMovie()));
            
            ticketDTOList.add(ticketDTO);
        });

        return ticketDTOList;
    }

}
