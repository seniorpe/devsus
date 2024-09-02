package pe.senior.rest.account.api.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pe.senior.rest.account.application.dto.CuentaDTO;
import pe.senior.rest.account.domain.entity.ClienteEntity;
import pe.senior.rest.account.domain.entity.CuentaEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T00:27:38-0500",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class CuentaMapperImpl implements CuentaMapper {

    @Override
    public CuentaDTO toDTO(CuentaEntity cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        CuentaDTO cuentaDTO = new CuentaDTO();

        cuentaDTO.setClienteId( cuentaClienteId( cuenta ) );
        cuentaDTO.setId( cuenta.getId() );
        cuentaDTO.setNumeroCuenta( cuenta.getNumeroCuenta() );
        cuentaDTO.setTipoCuenta( cuenta.getTipoCuenta() );
        cuentaDTO.setSaldoInicial( cuenta.getSaldoInicial() );
        cuentaDTO.setEstado( cuenta.getEstado() );

        return cuentaDTO;
    }

    @Override
    public CuentaEntity toEntity(CuentaDTO cuentaDTO) {
        if ( cuentaDTO == null ) {
            return null;
        }

        CuentaEntity cuentaEntity = new CuentaEntity();

        cuentaEntity.setCliente( cuentaDTOToClienteEntity( cuentaDTO ) );
        cuentaEntity.setId( cuentaDTO.getId() );
        cuentaEntity.setClienteId( cuentaDTO.getClienteId() );
        cuentaEntity.setNumeroCuenta( cuentaDTO.getNumeroCuenta() );
        cuentaEntity.setTipoCuenta( cuentaDTO.getTipoCuenta() );
        cuentaEntity.setSaldoInicial( cuentaDTO.getSaldoInicial() );
        cuentaEntity.setEstado( cuentaDTO.getEstado() );

        return cuentaEntity;
    }

    private Long cuentaClienteId(CuentaEntity cuentaEntity) {
        if ( cuentaEntity == null ) {
            return null;
        }
        ClienteEntity cliente = cuentaEntity.getCliente();
        if ( cliente == null ) {
            return null;
        }
        Long id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected ClienteEntity cuentaDTOToClienteEntity(CuentaDTO cuentaDTO) {
        if ( cuentaDTO == null ) {
            return null;
        }

        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setId( cuentaDTO.getClienteId() );

        return clienteEntity;
    }
}
