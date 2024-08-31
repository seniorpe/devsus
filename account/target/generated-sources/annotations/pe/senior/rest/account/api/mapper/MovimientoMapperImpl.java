package pe.senior.rest.account.api.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pe.senior.rest.account.application.dto.CuentaDTO;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.domain.entity.CuentaEntity;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T00:59:27-0500",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class MovimientoMapperImpl implements MovimientoMapper {

    @Override
    public MovimientoDTO toDTO(MovimientoEntity movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        MovimientoDTO movimientoDTO = new MovimientoDTO();

        movimientoDTO.setCuenta( cuentaEntityToCuentaDTO( movimiento.getCuenta() ) );
        movimientoDTO.setFecha( movimiento.getFecha() );
        movimientoDTO.setId( movimiento.getId() );
        movimientoDTO.setSaldo( movimiento.getSaldo() );
        movimientoDTO.setTipoMovimiento( movimiento.getTipoMovimiento() );
        movimientoDTO.setValor( movimiento.getValor() );

        return movimientoDTO;
    }

    @Override
    public MovimientoEntity toEntity(MovimientoDTO movimientoDTO) {
        if ( movimientoDTO == null ) {
            return null;
        }

        MovimientoEntity movimientoEntity = new MovimientoEntity();

        movimientoEntity.setCuenta( cuentaDTOToCuentaEntity( movimientoDTO.getCuenta() ) );
        movimientoEntity.setFecha( movimientoDTO.getFecha() );
        movimientoEntity.setId( movimientoDTO.getId() );
        movimientoEntity.setSaldo( movimientoDTO.getSaldo() );
        movimientoEntity.setTipoMovimiento( movimientoDTO.getTipoMovimiento() );
        movimientoEntity.setValor( movimientoDTO.getValor() );

        return movimientoEntity;
    }

    protected CuentaDTO cuentaEntityToCuentaDTO(CuentaEntity cuentaEntity) {
        if ( cuentaEntity == null ) {
            return null;
        }

        CuentaDTO cuentaDTO = new CuentaDTO();

        cuentaDTO.setEstado( cuentaEntity.getEstado() );
        cuentaDTO.setId( cuentaEntity.getId() );
        cuentaDTO.setNumeroCuenta( cuentaEntity.getNumeroCuenta() );
        cuentaDTO.setSaldoInicial( cuentaEntity.getSaldoInicial() );
        cuentaDTO.setTipoCuenta( cuentaEntity.getTipoCuenta() );

        return cuentaDTO;
    }

    protected CuentaEntity cuentaDTOToCuentaEntity(CuentaDTO cuentaDTO) {
        if ( cuentaDTO == null ) {
            return null;
        }

        CuentaEntity cuentaEntity = new CuentaEntity();

        cuentaEntity.setEstado( cuentaDTO.getEstado() );
        cuentaEntity.setId( cuentaDTO.getId() );
        cuentaEntity.setNumeroCuenta( cuentaDTO.getNumeroCuenta() );
        cuentaEntity.setSaldoInicial( cuentaDTO.getSaldoInicial() );
        cuentaEntity.setTipoCuenta( cuentaDTO.getTipoCuenta() );

        return cuentaEntity;
    }
}
