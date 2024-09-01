package pe.senior.rest.people.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senior.rest.people.application.service.ClienteService;
import pe.senior.rest.people.domain.entity.ClienteEntity;
import pe.senior.rest.people.infrastructure.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<ClienteEntity> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
