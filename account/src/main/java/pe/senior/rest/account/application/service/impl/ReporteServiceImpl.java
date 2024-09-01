package pe.senior.rest.account.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.senior.rest.account.application.dto.ReporteDTO;
import pe.senior.rest.account.application.service.ReporteService;
import pe.senior.rest.account.domain.entity.PersonaEntity;
import pe.senior.rest.account.infrastructure.exception.NotFoundException;
import pe.senior.rest.account.infrastructure.repository.MovimientoRepository;
import pe.senior.rest.account.infrastructure.repository.PersonaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final PersonaRepository personaRepository;
    private final MovimientoRepository movimientoRepository;


    @Override
    public List<ReporteDTO> findMovements(LocalDate fechaInicio, LocalDate fechaFin, String cliente) {
        Optional<PersonaEntity> optionalPersona = personaRepository.findByNombre(cliente);
        PersonaEntity persona = optionalPersona.orElseThrow(() -> new NotFoundException("Cliente no encontrado"));

        return List.of();
    }
}
