package pe.senior.rest.account.application.service;

import pe.senior.rest.account.domain.entity.CuentaEntity;

import java.util.List;
import java.util.Optional;

public interface CuentaService {
    List<CuentaEntity> findAll();
    Optional<CuentaEntity> findById(Long id);
    CuentaEntity save(CuentaEntity cuenta);
    void deleteById(Long id);
}
