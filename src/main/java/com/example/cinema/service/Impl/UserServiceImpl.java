package com.example.cinema.service.Impl;

import com.example.cinema.domain.data.Ticket;
import com.example.cinema.domain.data.User;
import com.example.cinema.domain.dto.user.CreateUserDTO;
import com.example.cinema.domain.dto.user.UpdateUserDTO;
import com.example.cinema.domain.dto.user.UserDTO;
import com.example.cinema.domain.mapper.UserMapper;
import com.example.cinema.repository.TicketRepository;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public UserDTO getById(Long id) {
        return userMapper.toDTO(userRepository.getReferenceById(id));
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        List<Ticket> ticketList = ticketRepository.findAllById(createUserDTO.getTicketIds());

        User user = userMapper.toCreateEntity(createUserDTO, ticketList);
        userRepository.save(user);

        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO update(Long id, UpdateUserDTO updateUserDTO) {

        return userMapper.toDTO(userRepository.save(userMapper.toUpdateEntity(userRepository.getReferenceById(id), updateUserDTO)));
    }

    @Override
    public void delete(Long id) {

        userRepository.delete(userRepository.getReferenceById(id));
    }
}
