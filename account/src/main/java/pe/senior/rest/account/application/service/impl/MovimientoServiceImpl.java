package pe.senior.rest.account.application.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.senior.rest.account.application.service.MovimientoService;
import pe.senior.rest.account.domain.entity.CuentaEntity;
import pe.senior.rest.account.domain.entity.MovimientoEntity;
import pe.senior.rest.account.infrastructure.exception.InsufficientFundsException;
import pe.senior.rest.account.infrastructure.exception.NotFoundException;
import pe.senior.rest.account.infrastructure.repository.CuentaRepository;
import pe.senior.rest.account.infrastructure.repository.MovimientoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService{

    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;

    @Override
    public List<MovimientoEntity> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Optional<MovimientoEntity> findById(Long id) {
        return movimientoRepository.findById(id);
    }

    @Override
    public MovimientoEntity save(MovimientoEntity movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }

    @Transactional
    @Override
    public MovimientoEntity register(String numeroCuenta, String tipoMovimiento, BigDecimal valor) throws Exception {

        Optional<CuentaEntity> optionalCuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        CuentaEntity cuenta = optionalCuenta.orElseThrow(() -> new NotFoundException("Cuenta no encontrada"));
        
        BigDecimal saldoDisponible = cuenta.getSaldoInicial();

        if (tipoMovimiento.equalsIgnoreCase("Retiro") && saldoDisponible.subtract(valor.abs()).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException("Saldo no disponible");
        }
        
        BigDecimal nuevoSaldo = tipoMovimiento.equalsIgnoreCase("Retiro") 
                        ? saldoDisponible.subtract(valor.abs()) 
                        : saldoDisponible.add(valor.abs());

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        MovimientoEntity movimiento = new MovimientoEntity();
        movimiento.setCuenta(cuenta);
        movimiento.setFecha(LocalDate.now());
        movimiento.setTipoMovimiento(tipoMovimiento);
        movimiento.setValor(valor);
        movimiento.setSaldo(nuevoSaldo);

        return  movimientoRepository.save(movimiento);
    }
}
