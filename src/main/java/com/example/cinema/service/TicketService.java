package com.example.cinema.service;

import com.example.cinema.domain.dto.ticket.CreateTicketDTO;
import com.example.cinema.domain.dto.ticket.TicketDTO;
import com.example.cinema.domain.dto.ticket.SearchTicketDTO;
import com.example.cinema.domain.dto.ticket.UpdateTicketDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {

    TicketDTO create(CreateTicketDTO createTicketDTO);

    TicketDTO update(Long id, UpdateTicketDTO updateTicketDTO);

    TicketDTO getById(Long id);

    List<TicketDTO> searchByCriteria(SearchTicketDTO searchTicketDTO, Pageable pageable);

    void delete(Long id);

    TicketDTO buyTicket(Long ticketId, Long userId);

    List<TicketDTO> getAll();

}
