package com.ceiba.curso.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAsistenciaCruso {
    private Long id;
    private String numeroComparendo;
    private String identificacionInfractor;
    private LocalDateTime fechaAsistencia;
}
