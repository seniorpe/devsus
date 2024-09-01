package pe.senior.rest.account.application.service;

import pe.senior.rest.account.domain.entity.MovimientoEntity;

import java.util.List;
import java.util.Optional;


public interface MovimientoService {
    List<MovimientoEntity> findAll();
    Optional<MovimientoEntity> findById(Long id);
    MovimientoEntity save(MovimientoEntity cliente);
    void deleteById(Long id);
}
