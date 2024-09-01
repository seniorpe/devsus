package pe.senior.rest.account.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.senior.rest.account.api.mapper.CuentaMapper;
import pe.senior.rest.account.application.dto.ReporteDTO;
import pe.senior.rest.account.application.service.ReporteService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReporteController {
    private final ReporteService reporteService;
    private final CuentaMapper cuentaMapper;

    @GetMapping
    @Operation(summary = "Get all accounts", description = "Get a list of all registered accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<ReporteDTO>> getReportes(@RequestParam("fechaInicio") LocalDate fechaInicio,
                                                       @RequestParam("fechaFin") LocalDate fechaFin,
                                                       @RequestParam("cliente") String cliente) {
        List<ReporteDTO> movimientos = reporteService.findMovements(fechaInicio, fechaFin, cliente);

        return ResponseEntity.ok(movimientos);
    }
}