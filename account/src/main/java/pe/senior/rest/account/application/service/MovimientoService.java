package pe.senior.rest.account.application.service;

import pe.senior.rest.account.domain.entity.MovimientoEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface MovimientoService {
    List<MovimientoEntity> findAll();
    Optional<MovimientoEntity> findById(Long id);
    MovimientoEntity save(MovimientoEntity cliente);
    void deleteById(Long id);

    MovimientoEntity register(String numeroCuenta, String tipoMovimiento, BigDecimal valor) throws Exception;
}
