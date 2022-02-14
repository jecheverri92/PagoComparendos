package com.ceiba.comparendo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoComparendo {

    private Long id;
    private String numeroComparendo;
    private Integer tipoInfraccion;
    private String identificacionInfractor;
    private LocalDateTime fechaComparendo;
    private BigDecimal valorComparendo;
    private String pagado;
}
