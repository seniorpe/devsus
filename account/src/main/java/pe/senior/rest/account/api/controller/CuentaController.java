package pe.senior.rest.account.api.controller;

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
import pe.senior.rest.account.api.mapper.CuentaMapper;
import pe.senior.rest.account.application.dto.CuentaDTO;
import pe.senior.rest.account.application.dto.CuentaRegistroDTO;
import pe.senior.rest.account.application.service.CuentaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class CuentaController {
    private final CuentaService cuentaService;
    private final CuentaMapper cuentaMapper;

    @GetMapping
    @Operation(summary = "Get all accounts", description = "Get a list of all registered accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<CuentaDTO>> getAllCuentas() {
        List<CuentaDTO> cuentas = cuentaService.findAll()
                .stream()
                .map(cuentaMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a account by ID", description = "Get a specific account based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<CuentaDTO> findById(@PathVariable Long id) {
        return cuentaService.findById(id)
                .map(cuentaMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new account", description = "Create a new account and returns the created account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid account data provided")
    })
    public ResponseEntity<CuentaDTO> createCuenta(@RequestBody CuentaRegistroDTO cuentaDTO) {
        var savedCuenta = cuentaService.register(cuentaDTO);
        return new ResponseEntity<>(cuentaMapper.toDTO(savedCuenta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a cuenta", description = "Update an existing account based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "422", description = "Invalid account data provided")
    })
    public ResponseEntity<CuentaDTO> updateCuenta(@PathVariable Long id, @RequestBody CuentaDTO cuentaDTO) {
        return cuentaService.findById(id)
                .map(existingCuenta -> {
                    cuentaDTO.setId(existingCuenta.getId());
                    var cuenta = cuentaMapper.toEntity(cuentaDTO);
                    var updatedCuenta = cuentaService.save(cuenta);
                    return ResponseEntity.ok(cuentaMapper.toDTO(updatedCuenta));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an account", description = "Delete an existing account based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Account deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        if (cuentaService.findById(id).isPresent()) {
            cuentaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}