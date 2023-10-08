package com.example.cinema.service.Impl;

import com.example.cinema.domain.data.Movie;
import com.example.cinema.domain.data.Ticket;
import com.example.cinema.domain.data.User;
import com.example.cinema.domain.dto.ticket.CreateTicketDTO;
import com.example.cinema.domain.dto.ticket.TicketDTO;
import com.example.cinema.domain.dto.ticket.SearchTicketDTO;
import com.example.cinema.domain.dto.ticket.UpdateTicketDTO;
import com.example.cinema.domain.mapper.TicketMapper;
import com.example.cinema.repository.MovieRepository;
import com.example.cinema.repository.TicketRepository;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public TicketDTO create(CreateTicketDTO createTicketDTO) {
        Ticket ticket = ticketMapper.toCreateEntity(createTicketDTO);

        Movie movie = movieRepository.getReferenceById(createTicketDTO.getMovieId());
        ticket.setMovie(movie);

        return ticketMapper.toDto(ticketRepository.save(ticket));
    }

    @Override
    public TicketDTO update(Long id, UpdateTicketDTO updateTicketDTO) {
        Ticket ticket = ticketRepository.getReferenceById(id);

        ticket = ticketMapper.toUpdateEntity(ticket, updateTicketDTO);

        Long movieId = updateTicketDTO.getMovieId();

        if (movieId != null) {
            Movie movie = movieRepository.getById(movieId);
            ticket.setMovie(movie);
        }

        return ticketMapper.toDto(ticketRepository.save(ticket));
    }

    @Override
    public TicketDTO getById(Long id) {
        return ticketMapper.toDto(ticketRepository.getReferenceById(id));
    }

    @Override
    public List<TicketDTO> searchByCriteria(SearchTicketDTO searchTicketDTO, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> orderTicketRoot = criteriaQuery.from(Ticket.class);

        List<Predicate> predicates = initializePredicates(searchTicketDTO, criteriaBuilder, orderTicketRoot);
        CriteriaQuery<Ticket> result = criteriaQuery.select(orderTicketRoot).where(predicates.toArray(new Predicate[0]));

        TypedQuery<Ticket> typedQuery = entityManager.createQuery(result);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(pageable.getPageSize());

        List<Ticket> ticketList = typedQuery.getResultList();

        return ticketMapper.toDto(ticketList);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDTO buyTicket(Long ticketId, Long userId) {
        User user = userRepository.getById(userId);

        Ticket ticket = ticketRepository.getById(ticketId);
        ticket.setStatus(false);
        ticket.setUser(user);

        return ticketMapper.toDto(ticket);
    }

    @Override
    public List<TicketDTO> getAll() {
        return ticketMapper.toDto(ticketRepository.findAll());
    }

    private ArrayList<Predicate> initializePredicates(SearchTicketDTO searchTicketDTO, CriteriaBuilder criteriaBuilder, Root<Ticket> orderTicketRoot) {
        Double minPrice = searchTicketDTO.getMinPrice();
        Double maxPrice = searchTicketDTO.getMaxPrice();
        Integer row = searchTicketDTO.getRow();
        Integer seat = searchTicketDTO.getSeat();
        Long movieId = searchTicketDTO.getMovieId();

        ArrayList<Predicate> predicates = new ArrayList<>();

        if (row != null) {
            predicates.add(criteriaBuilder.equal(orderTicketRoot.get("rowPlace"), row));
        }
        if (seat != null) {
            predicates.add(criteriaBuilder.equal(orderTicketRoot.get("seat"), seat));
        }
        if (minPrice != null && maxPrice != null) {
            predicates.add(criteriaBuilder.between(orderTicketRoot.get("price"), minPrice, maxPrice));
        }
        if (movieId != null) {
            predicates.add(criteriaBuilder.equal(orderTicketRoot.get("movie"), movieId));
        }

        return predicates;
    }

}
