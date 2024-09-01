package pe.senior.rest.account.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.senior.rest.account.application.dto.CuentaRegistroDTO;
import pe.senior.rest.account.application.service.CuentaService;
import pe.senior.rest.account.domain.entity.ClienteEntity;
import pe.senior.rest.account.domain.entity.CuentaEntity;
import pe.senior.rest.account.domain.entity.MovimientoEntity;
import pe.senior.rest.account.domain.entity.PersonaEntity;
import pe.senior.rest.account.infrastructure.exception.NotFoundException;
import pe.senior.rest.account.infrastructure.repository.ClienteRepository;
import pe.senior.rest.account.infrastructure.repository.CuentaRepository;
import pe.senior.rest.account.infrastructure.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService{

    private final PersonaRepository personaRepository;
    private final ClienteRepository clienteRepository;
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

    @Override
    public CuentaEntity register(CuentaRegistroDTO dto) {
        Optional<PersonaEntity> optionalPersona = personaRepository.findByNombre(dto.getCliente());
        PersonaEntity persona = optionalPersona.orElseThrow(() -> new NotFoundException("Cliente no encontrado"));

        CuentaEntity cuenta = new CuentaEntity();
        cuenta.setCliente(persona.getCliente());
        cuenta.setNumeroCuenta(dto.getNumeroCuenta());
        cuenta.setTipoCuenta(dto.getTipoCuenta());
        cuenta.setSaldoInicial(dto.getSaldoInicial());
        cuenta.setEstado(dto.getEstado());

        return cuentaRepository.save(cuenta);
    }
}
