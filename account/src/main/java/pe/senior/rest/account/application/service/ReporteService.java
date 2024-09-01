package pe.senior.rest.account.application.service;

import pe.senior.rest.account.application.dto.ReporteDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReporteService {
    List<ReporteDTO> findMovements(LocalDate fechaInicio, LocalDate fechaFin, String cliente);
}
