package com.ceiba.comparendo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class DtoPagoComparendo {

    private final String EL_NUMERO_COMPARENDO_ES_OBLIGATORIO = "El numero de comparendo es obligatorio";
    private final String EL_VALOR_PAGADO_ES_OBLIGATORIO = "El valor pagado es obligatorio";

    private String numeroComparendo;
    private BigDecimal valorPagado;

    public DtoPagoComparendo(String numeroComparendo, BigDecimal valorPagado) {
        validarObligatorio(numeroComparendo, EL_NUMERO_COMPARENDO_ES_OBLIGATORIO);
        validarObligatorio(valorPagado, EL_VALOR_PAGADO_ES_OBLIGATORIO);

        this.numeroComparendo = numeroComparendo;
        this.valorPagado = valorPagado;
    }
}
