package pe.senior.rest.account.api.mapper;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.application.dto.ReporteDTO;
import pe.senior.rest.account.domain.entity.ClienteEntity;
import pe.senior.rest.account.domain.entity.CuentaEntity;
import pe.senior.rest.account.domain.entity.MovimientoEntity;
import pe.senior.rest.account.domain.entity.PersonaEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T00:27:38-0500",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class MovimientoMapperImpl implements MovimientoMapper {

    @Override
    public MovimientoDTO toDTO(MovimientoEntity movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        MovimientoDTO movimientoDTO = new MovimientoDTO();

        movimientoDTO.setCuentaId( movimientoCuentaId( movimiento ) );
        movimientoDTO.setId( movimiento.getId() );
        movimientoDTO.setFecha( movimiento.getFecha() );
        movimientoDTO.setTipoMovimiento( movimiento.getTipoMovimiento() );
        movimientoDTO.setValor( movimiento.getValor() );
        movimientoDTO.setSaldo( movimiento.getSaldo() );

        return movimientoDTO;
    }

    @Override
    public MovimientoEntity toEntity(MovimientoDTO movimientoDTO) {
        if ( movimientoDTO == null ) {
            return null;
        }

        MovimientoEntity movimientoEntity = new MovimientoEntity();

        movimientoEntity.setId( movimientoDTO.getId() );
        movimientoEntity.setCuentaId( movimientoDTO.getCuentaId() );
        movimientoEntity.setFecha( movimientoDTO.getFecha() );
        movimientoEntity.setTipoMovimiento( movimientoDTO.getTipoMovimiento() );
        movimientoEntity.setValor( movimientoDTO.getValor() );
        movimientoEntity.setSaldo( movimientoDTO.getSaldo() );

        return movimientoEntity;
    }

    @Override
    public ReporteDTO toReportDTO(MovimientoEntity movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        ReporteDTO reporteDTO = new ReporteDTO();

        reporteDTO.setCliente( movimientoCuentaClientePersonaNombre( movimiento ) );
        reporteDTO.setNumeroCuenta( movimientoCuentaNumeroCuenta( movimiento ) );
        reporteDTO.setTipoCuenta( movimientoCuentaTipoCuenta( movimiento ) );
        reporteDTO.setSaldoInicial( movimientoCuentaSaldoInicial( movimiento ) );
        if ( movimiento.getFecha() != null ) {
            reporteDTO.setFecha( DateTimeFormatter.ISO_LOCAL_DATE.format( movimiento.getFecha() ) );
        }
        reporteDTO.setTipoMovimiento( movimiento.getTipoMovimiento() );
        reporteDTO.setSaldo( movimiento.getSaldo() );

        return reporteDTO;
    }

    private Long movimientoCuentaId(MovimientoEntity movimientoEntity) {
        if ( movimientoEntity == null ) {
            return null;
        }
        CuentaEntity cuenta = movimientoEntity.getCuenta();
        if ( cuenta == null ) {
            return null;
        }
        Long id = cuenta.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String movimientoCuentaClientePersonaNombre(MovimientoEntity movimientoEntity) {
        if ( movimientoEntity == null ) {
            return null;
        }
        CuentaEntity cuenta = movimientoEntity.getCuenta();
        if ( cuenta == null ) {
            return null;
        }
        ClienteEntity cliente = cuenta.getCliente();
        if ( cliente == null ) {
            return null;
        }
        PersonaEntity persona = cliente.getPersona();
        if ( persona == null ) {
            return null;
        }
        String nombre = persona.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String movimientoCuentaNumeroCuenta(MovimientoEntity movimientoEntity) {
        if ( movimientoEntity == null ) {
            return null;
        }
        CuentaEntity cuenta = movimientoEntity.getCuenta();
        if ( cuenta == null ) {
            return null;
        }
        String numeroCuenta = cuenta.getNumeroCuenta();
        if ( numeroCuenta == null ) {
            return null;
        }
        return numeroCuenta;
    }

    private String movimientoCuentaTipoCuenta(MovimientoEntity movimientoEntity) {
        if ( movimientoEntity == null ) {
            return null;
        }
        CuentaEntity cuenta = movimientoEntity.getCuenta();
        if ( cuenta == null ) {
            return null;
        }
        String tipoCuenta = cuenta.getTipoCuenta();
        if ( tipoCuenta == null ) {
            return null;
        }
        return tipoCuenta;
    }

    private BigDecimal movimientoCuentaSaldoInicial(MovimientoEntity movimientoEntity) {
        if ( movimientoEntity == null ) {
            return null;
        }
        CuentaEntity cuenta = movimientoEntity.getCuenta();
        if ( cuenta == null ) {
            return null;
        }
        BigDecimal saldoInicial = cuenta.getSaldoInicial();
        if ( saldoInicial == null ) {
            return null;
        }
        return saldoInicial;
    }
}
