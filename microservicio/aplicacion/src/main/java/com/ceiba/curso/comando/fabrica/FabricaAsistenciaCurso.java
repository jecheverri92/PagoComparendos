package com.ceiba.curso.comando.fabrica;

import com.ceiba.curso.comando.ComandoAsistenciaCruso;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;
import org.springframework.stereotype.Component;

@Component
public class FabricaAsistenciaCurso {
    public AsistenciaCurso crear(ComandoAsistenciaCruso comandoAsistenciaCruso){
        return new AsistenciaCurso(comandoAsistenciaCruso.getId(),
                comandoAsistenciaCruso.getNumeroComparendo(),
                comandoAsistenciaCruso.getIdentificacionInfractor(),
                comandoAsistenciaCruso.getFechaAsistencia());
    }
}
