package pe.senior.rest.account.api.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pe.senior.rest.account.application.dto.CuentaDTO;
import pe.senior.rest.account.domain.entity.CuentaEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T00:59:27-0500",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class CuentaMapperImpl implements CuentaMapper {

    @Override
    public CuentaDTO toDTO(CuentaEntity cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        CuentaDTO cuentaDTO = new CuentaDTO();

        cuentaDTO.setEstado( cuenta.getEstado() );
        cuentaDTO.setId( cuenta.getId() );
        cuentaDTO.setNumeroCuenta( cuenta.getNumeroCuenta() );
        cuentaDTO.setSaldoInicial( cuenta.getSaldoInicial() );
        cuentaDTO.setTipoCuenta( cuenta.getTipoCuenta() );

        return cuentaDTO;
    }

    @Override
    public CuentaEntity toEntity(CuentaDTO cuentaDTO) {
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
