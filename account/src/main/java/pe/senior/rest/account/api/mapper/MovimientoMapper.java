package pe.senior.rest.account.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(source = "cuenta.id", target = "cuentaId")
    MovimientoDTO toDTO(MovimientoEntity movimiento);

    MovimientoEntity toEntity(MovimientoDTO movimientoDTO);
}
