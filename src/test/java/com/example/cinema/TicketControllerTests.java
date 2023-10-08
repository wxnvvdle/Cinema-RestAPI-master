package com.example.cinema;

import com.example.cinema.controller.TicketController;
import com.example.cinema.domain.dto.ticket.CreateTicketDTO;
import com.example.cinema.domain.dto.ticket.SearchTicketDTO;
import com.example.cinema.domain.dto.ticket.UpdateTicketDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-integrationtest.properties")
@Sql(value = {"/create-movies.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-orders.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TicketControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TicketController ticketController;

    @Test
    void contextLoads() {
        assertThat(ticketController).isNotNull();
    }

    @Test
    public void createAndGetEntityTest() throws Exception {
        CreateTicketDTO createTicketDTO = new CreateTicketDTO(5, 8, 100.00,true , 1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(createTicketDTO);

        mockMvc.perform(post("/api/order")
                        .contentType(APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void getByIdTest() throws Exception {
        this.mockMvc.perform(get("/api/order/1")).andExpect(status().isOk());
    }

    @Test
    public void searchByCriteriaTest() throws Exception {
        SearchTicketDTO searchTicketDTO = new SearchTicketDTO(5, 8, 100.00, 120.00, true, 1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(searchTicketDTO);

        mockMvc.perform(get("/api/order/search-by-criteria")
                        .contentType(APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAndGetEntityTest() throws Exception {
        UpdateTicketDTO updateTicketDTO = new UpdateTicketDTO(5, 8, 100.00, true, 1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(updateTicketDTO);

        mockMvc.perform(put("/api/order/3")
                        .contentType(APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

}
