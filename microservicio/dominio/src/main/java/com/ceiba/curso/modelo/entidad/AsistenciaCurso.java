package com.ceiba.curso.modelo.entidad;

import com.ceiba.comparendo.modelo.entidad.Comparendo;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class AsistenciaCurso {

    private static final String MENSAJE_NUMERO_COMPARENDO_OBLIGATORIO = "El numeroComparendo es obligatorio";
    private static final String MENSAJE_FECHA_ASISTENCIA_OBLIGATORIA = "La fechaAsistencia es obligatoria";
    private static final String MENSAJE_IDENTIFICACION_INFRACTOR_OBLIGATORIA = "La identificacionInfractor es obligatoria";

    private Long id;
    private String numeroComparendo;
    private String identificacionInfractor;
    private LocalDateTime fechaAsistencia;

    public AsistenciaCurso(Long id, String numeroComparendo, String identificacionInfractor, LocalDateTime fechaAsistencia) {

        validarObligatorio(numeroComparendo, MENSAJE_NUMERO_COMPARENDO_OBLIGATORIO);
        validarObligatorio(fechaAsistencia, MENSAJE_FECHA_ASISTENCIA_OBLIGATORIA);
        validarObligatorio(identificacionInfractor, MENSAJE_IDENTIFICACION_INFRACTOR_OBLIGATORIA);

        this.id = id;
        this.numeroComparendo = numeroComparendo;
        this.fechaAsistencia = fechaAsistencia;
        this.identificacionInfractor = identificacionInfractor;
    }
}
