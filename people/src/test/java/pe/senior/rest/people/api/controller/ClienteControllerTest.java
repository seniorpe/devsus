package pe.senior.rest.people.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pe.senior.rest.people.api.mapper.ClienteMapper;
import pe.senior.rest.people.application.dto.ClienteDTO;
import pe.senior.rest.people.application.service.ClienteService;
import pe.senior.rest.people.domain.entity.ClienteEntity;

import java.util.Collections;
import java.util.Optional;

public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteController clienteController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllClientes() throws Exception {
        ClienteDTO clienteDTO = new ClienteDTO();
        when(clienteService.findAll()).thenReturn(Collections.singletonList(new ClienteEntity()));
        when(clienteMapper.toDTO(any(ClienteEntity.class))).thenReturn(clienteDTO);

        mockMvc.perform(get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(clienteDTO.getId()));
    }

    @Test
    void testFindById() throws Exception {
        Long id = 1L;
        ClienteEntity cliente = new ClienteEntity();
        ClienteDTO clienteDTO = new ClienteDTO();
        when(clienteService.findById(id)).thenReturn(Optional.of(cliente));
        when(clienteMapper.toDTO(any(ClienteEntity.class))).thenReturn(clienteDTO);

        mockMvc.perform(get("/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(clienteDTO.getId()));
    }

    @Test
    void testCreateCliente() throws Exception {
        ClienteEntity cliente = new ClienteEntity();
        ClienteDTO clienteDTO = new ClienteDTO();
        when(clienteService.save(any(ClienteEntity.class))).thenReturn(cliente);
        when(clienteMapper.toDTO(any(ClienteEntity.class))).thenReturn(clienteDTO);
        when(clienteMapper.toEntity(any(ClienteDTO.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(clienteDTO.getId()));
    }

    @Test
    void testUpdateCliente() throws Exception {
        Long id = 1L;
        ClienteEntity cliente = new ClienteEntity();
        ClienteDTO clienteDTO = new ClienteDTO();
        when(clienteService.findById(id)).thenReturn(Optional.of(cliente));
        when(clienteMapper.toEntity(any(ClienteDTO.class))).thenReturn(cliente);
        when(clienteService.save(any(ClienteEntity.class))).thenReturn(cliente);
        when(clienteMapper.toDTO(any(ClienteEntity.class))).thenReturn(clienteDTO);

        mockMvc.perform(put("/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(clienteDTO.getId()));
    }

    @Test
    void testDeleteCliente() throws Exception {
        Long id = 1L;
        when(clienteService.findById(id)).thenReturn(Optional.of(new ClienteEntity()));

        mockMvc.perform(delete("/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteCliente_NotFound() throws Exception {
        Long id = 1L;
        when(clienteService.findById(id)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
