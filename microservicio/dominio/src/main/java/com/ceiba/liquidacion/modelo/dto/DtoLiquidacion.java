package com.ceiba.liquidacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoLiquidacion {
    private Long id;
    private String numeroComparendo;
    private Integer tipoInfraccion;
    private String identificacionInfractor;
    private LocalDateTime fechaComparendo;
    private String activo;
}
