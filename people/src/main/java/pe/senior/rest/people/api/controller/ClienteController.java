package pe.senior.rest.people.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.senior.rest.people.api.mapper.ClienteMapper;
import pe.senior.rest.people.application.dto.ClienteDTO;
import pe.senior.rest.people.application.service.ClienteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    @GetMapping
    @Operation(summary = "Get all customers", description = "Get a list of all registered customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer by ID", description = "Get a specific customer based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        return clienteService.findById(id)
                .map(clienteMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new customer", description = "Create a new customer and returns the created customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid customer data provided")
    })
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        var cliente = clienteMapper.toEntity(clienteDTO);
        var savedCliente = clienteService.save(cliente);
        return new ResponseEntity<>(clienteMapper.toDTO(savedCliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a cliente", description = "Update an existing customer based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "422", description = "Invalid customer data provided")
    })
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.findById(id)
                .map(existingCliente -> {
                    clienteDTO.setId(existingCliente.getId());
                    var cliente = clienteMapper.toEntity(clienteDTO);
                    var updatedCliente = clienteService.save(cliente);
                    return ResponseEntity.ok(clienteMapper.toDTO(updatedCliente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer", description = "Delete an existing customer based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Customer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
