package pe.senior.rest.account.api.mapper;

import org.mapstruct.Mapper;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    MovimientoDTO toDTO(MovimientoEntity movimiento);

    MovimientoEntity toEntity(MovimientoDTO movimientoDTO);
}
