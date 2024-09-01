package pe.senior.rest.account.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovimientoRegistroDTO {
    private String numeroCuenta;
    private String tipoMovimiento;
    private BigDecimal valor;
}

