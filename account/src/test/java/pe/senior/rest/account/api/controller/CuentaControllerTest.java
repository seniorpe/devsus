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
import pe.senior.rest.account.api.mapper.CuentaMapper;
import pe.senior.rest.account.application.dto.CuentaDTO;
import pe.senior.rest.account.application.dto.CuentaRegistroDTO;
import pe.senior.rest.account.application.service.CuentaService;
import pe.senior.rest.account.domain.entity.CuentaEntity;

import java.util.Collections;
import java.util.Optional;

public class CuentaControllerTest {

    @Mock
    private CuentaService cuentaService;

    @Mock
    private CuentaMapper cuentaMapper;

    @InjectMocks
    private CuentaController cuentaController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllCuentas() throws Exception {
        CuentaDTO cuentaDTO = new CuentaDTO();
        when(cuentaService.findAll()).thenReturn(Collections.singletonList(new CuentaEntity()));
        when(cuentaMapper.toDTO(any(CuentaEntity.class))).thenReturn(cuentaDTO);

        mockMvc.perform(get("/cuentas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(cuentaDTO.getId()));
    }

    @Test
    void testFindById() throws Exception {
        Long id = 1L;
        CuentaEntity cuenta = new CuentaEntity();
        CuentaDTO cuentaDTO = new CuentaDTO();
        when(cuentaService.findById(id)).thenReturn(Optional.of(cuenta));
        when(cuentaMapper.toDTO(any(CuentaEntity.class))).thenReturn(cuentaDTO);

        mockMvc.perform(get("/cuentas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cuentaDTO.getId()));
    }

    @Test
    void testCreateCuenta() throws Exception {
        CuentaRegistroDTO cuentaRegistroDTO = new CuentaRegistroDTO();
        CuentaEntity cuenta = new CuentaEntity();
        CuentaDTO cuentaDTO = new CuentaDTO();
        when(cuentaService.register(any(CuentaRegistroDTO.class))).thenReturn(cuenta);
        when(cuentaMapper.toDTO(any(CuentaEntity.class))).thenReturn(cuentaDTO);

        mockMvc.perform(post("/cuentas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cuentaRegistroDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(cuentaDTO.getId()));
    }

    @Test
    void testUpdateCuenta() throws Exception {
        Long id = 1L;
        CuentaEntity cuenta = new CuentaEntity();
        CuentaDTO cuentaDTO = new CuentaDTO();
        when(cuentaService.findById(id)).thenReturn(Optional.of(cuenta));
        when(cuentaMapper.toEntity(any(CuentaDTO.class))).thenReturn(cuenta);
        when(cuentaService.save(any(CuentaEntity.class))).thenReturn(cuenta);
        when(cuentaMapper.toDTO(any(CuentaEntity.class))).thenReturn(cuentaDTO);

        mockMvc.perform(put("/cuentas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cuentaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cuentaDTO.getId()));
    }

    @Test
    void testDeleteCuenta() throws Exception {
        Long id = 1L;
        when(cuentaService.findById(id)).thenReturn(Optional.of(new CuentaEntity()));

        mockMvc.perform(delete("/cuentas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteCuenta_NotFound() throws Exception {
        Long id = 1L;
        when(cuentaService.findById(id)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/cuentas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
