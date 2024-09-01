package pe.senior.rest.people.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.senior.rest.people.application.dto.ClienteDTO;
import pe.senior.rest.people.domain.entity.ClienteEntity;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "persona.nombre", target = "nombre")
    @Mapping(source = "persona.genero", target = "genero")
    @Mapping(source = "persona.edad", target = "edad")
    @Mapping(source = "persona.identificacion", target = "identificacion")    
    @Mapping(source = "persona.direccion", target = "direccion")
    @Mapping(source = "persona.telefono", target = "telefono")
    ClienteDTO toDTO(ClienteEntity cliente);

    @Mapping(source = "id", target = "persona.id")
    @Mapping(source = "nombre", target = "persona.nombre")
    @Mapping(source = "genero", target = "persona.genero")
    @Mapping(source = "edad", target = "persona.edad")
    @Mapping(source = "identificacion", target = "persona.identificacion")
    @Mapping(source = "direccion", target = "persona.direccion")
    @Mapping(source = "telefono", target = "persona.telefono")
    @Mapping(target = "persona", ignore = true)
    ClienteEntity toEntity(ClienteDTO clienteDTO);
}
