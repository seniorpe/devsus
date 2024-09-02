package pe.senior.rest.account.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReporteDTO {
    private String fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private boolean estado;
    private String tipoMovimiento;
    private BigDecimal saldo;
}