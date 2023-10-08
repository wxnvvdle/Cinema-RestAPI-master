package com.example.cinema.domain.mapper;

import com.example.cinema.domain.data.Ticket;
import com.example.cinema.domain.data.User;
import com.example.cinema.domain.dto.user.CreateUserDTO;
import com.example.cinema.domain.dto.user.UpdateUserDTO;
import com.example.cinema.domain.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private TicketMapper ticketMapper;

    public User toCreateEntity(CreateUserDTO createUserDTO, List<Ticket> ticketList) {
        User user = new User();

        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setAge(createUserDTO.getAge());
        user.setCity(createUserDTO.getCity());
        if (!ticketList.isEmpty()) {
            user.setTicketList(ticketList);
        }

        return user;
    }

    public User toUpdateEntity(User user, UpdateUserDTO updateUserDTO) {
        user.setFirstName(updateUserDTO.getFirstName());
        user.setLastName(updateUserDTO.getLastName());
        user.setAge(user.getAge());
        user.setCity(user.getCity());

        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(user.getAge());
        userDTO.setCity(user.getCity());
        userDTO.setTicketList(ticketMapper.toDto(user.getTicketList()));

        return userDTO;
    }

    public List<UserDTO> ToDTO(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();

        userList.forEach(user -> {
            UserDTO userDTO = new UserDTO();

            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setAge(user.getAge());
            userDTO.setCity(user.getCity());
            userDTO.setTicketList(ticketMapper.toDto(user.getTicketList()));

            userDTOList.add(userDTO);
        });

        return userDTOList;
    }
}
