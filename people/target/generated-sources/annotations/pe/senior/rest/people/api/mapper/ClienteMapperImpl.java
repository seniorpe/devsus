package pe.senior.rest.people.api.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pe.senior.rest.people.application.dto.ClienteDTO;
import pe.senior.rest.people.domain.entity.ClienteEntity;
import pe.senior.rest.people.domain.entity.PersonaEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T00:50:44-0500",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO toDTO(ClienteEntity cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setNombre( clientePersonaNombre( cliente ) );
        clienteDTO.setGenero( clientePersonaGenero( cliente ) );
        clienteDTO.setEdad( clientePersonaEdad( cliente ) );
        clienteDTO.setIdentificacion( clientePersonaIdentificacion( cliente ) );
        clienteDTO.setDireccion( clientePersonaDireccion( cliente ) );
        clienteDTO.setTelefono( clientePersonaTelefono( cliente ) );
        clienteDTO.setContrasena( cliente.getContrasena() );
        clienteDTO.setEstado( cliente.getEstado() );
        clienteDTO.setId( cliente.getId() );

        return clienteDTO;
    }

    @Override
    public ClienteEntity toEntity(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setPersona( clienteDTOToPersonaEntity( clienteDTO ) );
        clienteEntity.setContrasena( clienteDTO.getContrasena() );
        clienteEntity.setEstado( clienteDTO.getEstado() );
        clienteEntity.setId( clienteDTO.getId() );

        return clienteEntity;
    }

    private String clientePersonaNombre(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }
        PersonaEntity persona = clienteEntity.getPersona();
        if ( persona == null ) {
            return null;
        }
        String nombre = persona.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String clientePersonaGenero(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }
        PersonaEntity persona = clienteEntity.getPersona();
        if ( persona == null ) {
            return null;
        }
        String genero = persona.getGenero();
        if ( genero == null ) {
            return null;
        }
        return genero;
    }

    private Integer clientePersonaEdad(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }
        PersonaEntity persona = clienteEntity.getPersona();
        if ( persona == null ) {
            return null;
        }
        Integer edad = persona.getEdad();
        if ( edad == null ) {
            return null;
        }
        return edad;
    }

    private String clientePersonaIdentificacion(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }
        PersonaEntity persona = clienteEntity.getPersona();
        if ( persona == null ) {
            return null;
        }
        String identificacion = persona.getIdentificacion();
        if ( identificacion == null ) {
            return null;
        }
        return identificacion;
    }

    private String clientePersonaDireccion(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }
        PersonaEntity persona = clienteEntity.getPersona();
        if ( persona == null ) {
            return null;
        }
        String direccion = persona.getDireccion();
        if ( direccion == null ) {
            return null;
        }
        return direccion;
    }

    private String clientePersonaTelefono(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }
        PersonaEntity persona = clienteEntity.getPersona();
        if ( persona == null ) {
            return null;
        }
        String telefono = persona.getTelefono();
        if ( telefono == null ) {
            return null;
        }
        return telefono;
    }

    protected PersonaEntity clienteDTOToPersonaEntity(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        PersonaEntity personaEntity = new PersonaEntity();

        personaEntity.setId( clienteDTO.getId() );
        personaEntity.setNombre( clienteDTO.getNombre() );
        personaEntity.setGenero( clienteDTO.getGenero() );
        personaEntity.setEdad( clienteDTO.getEdad() );
        personaEntity.setIdentificacion( clienteDTO.getIdentificacion() );
        personaEntity.setDireccion( clienteDTO.getDireccion() );
        personaEntity.setTelefono( clienteDTO.getTelefono() );

        return personaEntity;
    }
}
