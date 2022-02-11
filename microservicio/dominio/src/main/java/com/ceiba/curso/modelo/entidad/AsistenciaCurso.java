package com.ceiba.curso.modelo.entidad;

import com.ceiba.comparendo.modelo.entidad.Comparendo;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class AsistenciaCurso {

    private static final String MENSAJE_ID_COMPARENDO_OBLIGATORIO = "El id_comparendo es obligatorio";
    private static final String MENSAJE_FECHA_ASISTENCIA_OBLIGATORIA = "La fecha_asistencia es obligatoria";

    private Long id;
    private Comparendo comparendo;
    private LocalDateTime fechaAsistencia;

    public AsistenciaCurso(Long id, Comparendo comparendo, LocalDateTime fechaAsistencia) {

        validarObligatorio(comparendo.getId(), MENSAJE_ID_COMPARENDO_OBLIGATORIO);
        validarObligatorio(fechaAsistencia, MENSAJE_FECHA_ASISTENCIA_OBLIGATORIA);

        this.id = id;
        this.comparendo = comparendo;
        this.fechaAsistencia = fechaAsistencia;
    }
}
