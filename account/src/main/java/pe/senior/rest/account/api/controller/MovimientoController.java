package pe.senior.rest.account.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import pe.senior.rest.account.api.mapper.MovimientoMapper;
import pe.senior.rest.account.application.dto.MovimientoDTO;
import pe.senior.rest.account.application.dto.MovimientoRegistroDTO;
import pe.senior.rest.account.application.service.MovimientoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovimientoController {
    private final MovimientoService movimientoService;
    private final MovimientoMapper movimientoMapper;

    @GetMapping
    @Operation(summary = "Get all movements", description = "Get a list of all registered movements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<MovimientoDTO>> getAllMovimientos() {
        List<MovimientoDTO> movimientos = movimientoService.findAll()
                .stream()
                .map(movimientoMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(movimientos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a movement by ID", description = "Get a specific movement based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Movement not found")
    })
    public ResponseEntity<MovimientoDTO> findById(@PathVariable Long id) {
        return movimientoService.findById(id)
                .map(movimientoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new movement", description = "Create a new movement and returns the created movement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movement created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid movement data provided")
    })
    public ResponseEntity<MovimientoDTO> createMovimiento(@RequestBody MovimientoRegistroDTO movimiento) throws Exception {
        var savedMovimiento = movimientoService.register(movimiento.getNumeroCuenta(), 
                                            movimiento.getTipoMovimiento(), movimiento.getValor());
        return new ResponseEntity<>(movimientoMapper.toDTO(savedMovimiento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a movimiento", description = "Update an existing movement based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movement updated successfully"),
            @ApiResponse(responseCode = "404", description = "Movement not found"),
            @ApiResponse(responseCode = "422", description = "Invalid movement data provided")
    })
    public ResponseEntity<MovimientoDTO> updateMovimiento(@PathVariable Long id, @RequestBody MovimientoDTO movimientoDTO) {
        return movimientoService.findById(id)
                .map(existingMovimiento -> {
                    movimientoDTO.setId(existingMovimiento.getId());
                    var movimiento = movimientoMapper.toEntity(movimientoDTO);
                    var updatedMovimiento = movimientoService.save(movimiento);
                    return ResponseEntity.ok(movimientoMapper.toDTO(updatedMovimiento));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an movement", description = "Delete an existing movement based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movement deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Movement not found")
    })
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        if (movimientoService.findById(id).isPresent()) {
            movimientoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}