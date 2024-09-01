package pe.senior.rest.people.application.service;

import pe.senior.rest.people.domain.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteEntity> findAll();
    Optional<ClienteEntity> findById(Long id);
    ClienteEntity save(ClienteEntity cliente);
    void deleteById(Long id);
}
