package pe.senior.rest.account.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.senior.rest.account.application.service.ReporteService;
import pe.senior.rest.account.domain.entity.MovimientoEntity;
import pe.senior.rest.account.infrastructure.repository.MovimientoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final MovimientoRepository movimientoRepository;

    @Override
    public List<MovimientoEntity> findMovements(LocalDate fechaInicio, LocalDate fechaFin, String cliente) {
        return movimientoRepository.findByFechaBetweenAndCliente(fechaInicio, fechaFin, cliente);
    }
}
