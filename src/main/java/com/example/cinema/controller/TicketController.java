package com.example.cinema.controller;

import com.example.cinema.domain.dto.ticket.CreateTicketDTO;
import com.example.cinema.domain.dto.ticket.SearchTicketDTO;
import com.example.cinema.domain.dto.ticket.TicketDTO;
import com.example.cinema.domain.dto.ticket.UpdateTicketDTO;
import com.example.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public TicketDTO create(@RequestBody CreateTicketDTO createTicketDTO) {
        return ticketService.create(createTicketDTO);
    }

    @GetMapping("/all")
    public List<TicketDTO> getAll() {
        return ticketService.getAll();
    }

    @GetMapping("one-ticket/{id}")
    public TicketDTO getById(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @GetMapping("/search-by-criteria")
    public List<TicketDTO> search(@RequestBody SearchTicketDTO searchTicketDTO, Pageable pageable) {
        return ticketService.searchByCriteria(searchTicketDTO, pageable);
    }

    @PutMapping("edit/{id}")
    public TicketDTO update(@PathVariable Long id, @RequestBody UpdateTicketDTO updateTicketDTO) {
        return ticketService.update(id, updateTicketDTO);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }

    @PutMapping("/buy-ticket")
    public TicketDTO buyTicket(@RequestParam Long ticketId, @RequestParam Long userId) {
        return ticketService.buyTicket(ticketId, userId);
    }
}
