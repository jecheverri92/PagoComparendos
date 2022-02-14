package com.ceiba.curso.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.curso.comando.ComandoAsistenciaCruso;
import com.ceiba.curso.comando.fabrica.FabricaAsistenciaCurso;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;
import com.ceiba.curso.servicio.ServicioRegistrarAsistenciaCurso;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarAsistenciaCurso implements ManejadorComandoRespuesta<ComandoAsistenciaCruso, ComandoRespuesta<Long>> {

    private final ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso;
    private final FabricaAsistenciaCurso fabricaAsistenciaCurso;

    public ManejadorRegistrarAsistenciaCurso(ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso, FabricaAsistenciaCurso fabricaAsistenciaCurso) {
        this.servicioRegistrarAsistenciaCurso = servicioRegistrarAsistenciaCurso;
        this.fabricaAsistenciaCurso = fabricaAsistenciaCurso;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoAsistenciaCruso comando) {
        AsistenciaCurso asistenciaCurso = this.fabricaAsistenciaCurso.crear(comando);
        return new ComandoRespuesta<>(this.servicioRegistrarAsistenciaCurso.ejecutar(asistenciaCurso));
    }
}
