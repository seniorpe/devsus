package pe.senior.rest.account.api.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.domain.entity.CuentaEntity;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-01T06:11:19-0500",
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
}
