package pe.senior.rest.account.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.senior.rest.account.application.dto.CuentaDTO;
import pe.senior.rest.account.domain.entity.CuentaEntity;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    @Mapping(source = "cliente.id", target = "clienteId")
    CuentaDTO toDTO(CuentaEntity cuenta);

    @Mapping(source = "clienteId", target = "cliente.id")
    CuentaEntity toEntity(CuentaDTO cuentaDTO);
}
