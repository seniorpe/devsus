package pe.senior.rest.account.application.service;

import pe.senior.rest.account.domain.entity.MovimientoEntity;

import java.time.LocalDate;
import java.util.List;

public interface ReporteService {
    List<MovimientoEntity> findMovements(LocalDate fechaInicio, LocalDate fechaFin, String cliente);
}
