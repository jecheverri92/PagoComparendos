package com.ceiba.comparendo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPagarComparendo {
    private String numeroComparendo;
    private BigDecimal valorPagado;
}
