package pe.senior.rest.account.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.senior.rest.account.application.service.CuentaService;
import pe.senior.rest.account.domain.entity.CuentaEntity;
import pe.senior.rest.account.infrastructure.repository.CuentaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService{

    private final CuentaRepository cuentaRepository;

    @Override
    public List<CuentaEntity> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<CuentaEntity> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public CuentaEntity save(CuentaEntity cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }
}
