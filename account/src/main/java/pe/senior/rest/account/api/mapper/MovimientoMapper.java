package pe.senior.rest.account.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.application.dto.ReporteDTO;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(source = "cuenta.id", target = "cuentaId")
    MovimientoDTO toDTO(MovimientoEntity movimiento);

    MovimientoEntity toEntity(MovimientoDTO movimientoDTO);

    @Mapping(source = "cuenta.cliente.persona.nombre", target = "cliente")
    @Mapping(source = "cuenta.numeroCuenta", target = "numeroCuenta")
    @Mapping(source = "cuenta.tipoCuenta", target = "tipoCuenta")
    @Mapping(source = "cuenta.saldoInicial", target = "saldoInicial")
    ReporteDTO toReportDTO(MovimientoEntity movimiento);
}
