package pe.senior.rest.account.api.controller;
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
import pe.senior.rest.account.api.mapper.MovimientoMapper;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.application.dto.MovimientoRegistroDTO;
import pe.senior.rest.account.application.service.MovimientoService;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

import java.util.Collections;
import java.util.Optional;

public class MovimientoControllerTest {

    @Mock
    private MovimientoService movimientoService;

    @Mock
    private MovimientoMapper movimientoMapper;

    @InjectMocks
    private MovimientoController movimientoController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(movimientoController).build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllMovimientos() throws Exception {
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        when(movimientoService.findAll()).thenReturn(Collections.singletonList(new MovimientoEntity()));
        when(movimientoMapper.toDTO(any(MovimientoEntity.class))).thenReturn(movimientoDTO);

        mockMvc.perform(get("/movimientos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(movimientoDTO.getId()));
    }

    @Test
    void testFindById() throws Exception {
        Long id = 1L;
        MovimientoEntity movimiento = new MovimientoEntity();
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        when(movimientoService.findById(id)).thenReturn(Optional.of(movimiento));
        when(movimientoMapper.toDTO(any(MovimientoEntity.class))).thenReturn(movimientoDTO);

        mockMvc.perform(get("/movimientos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(movimientoDTO.getId()));
    }

    @Test
    void testCreateMovimiento() throws Exception {
        MovimientoRegistroDTO movimientoRegistroDTO = new MovimientoRegistroDTO();
        MovimientoEntity movimiento = new MovimientoEntity();
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        when(movimientoService.register(any(), any(), any())).thenReturn(movimiento);
        when(movimientoMapper.toDTO(any(MovimientoEntity.class))).thenReturn(movimientoDTO);

        mockMvc.perform(post("/movimientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movimientoRegistroDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(movimientoDTO.getId()));
    }

    @Test
    void testUpdateMovimiento() throws Exception {
        Long id = 1L;
        MovimientoEntity movimiento = new MovimientoEntity();
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        when(movimientoService.findById(id)).thenReturn(Optional.of(movimiento));
        when(movimientoMapper.toEntity(any(MovimientoDTO.class))).thenReturn(movimiento);
        when(movimientoService.save(any(MovimientoEntity.class))).thenReturn(movimiento);
        when(movimientoMapper.toDTO(any(MovimientoEntity.class))).thenReturn(movimientoDTO);

        mockMvc.perform(put("/movimientos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movimientoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(movimientoDTO.getId()));
    }

    @Test
    void testDeleteMovimiento() throws Exception {
        Long id = 1L;
        when(movimientoService.findById(id)).thenReturn(Optional.of(new MovimientoEntity()));

        mockMvc.perform(delete("/movimientos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteMovimiento_NotFound() throws Exception {
        Long id = 1L;
        when(movimientoService.findById(id)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/movimientos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
