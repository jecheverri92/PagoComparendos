package com.ceiba.curso.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comparendo.comando.ComandoComparendo;
import com.ceiba.curso.comando.ComandoAsistenciaCruso;
import com.ceiba.curso.comando.manejador.ManejadorRegistrarAsistenciaCurso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
@Api(tags = { "Controlador comando curso"})
public class ComandoControladorAsistenciaCurso {

    private final ManejadorRegistrarAsistenciaCurso manejadorRegistrarAsistenciaCurso;

    public ComandoControladorAsistenciaCurso(ManejadorRegistrarAsistenciaCurso manejadorRegistrarAsistenciaCurso) {
        this.manejadorRegistrarAsistenciaCurso = manejadorRegistrarAsistenciaCurso;
    }

    @PostMapping
    @ApiOperation("Crear Asistencia Curso")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAsistenciaCruso comandoAsistenciaCruso) {
        return this.manejadorRegistrarAsistenciaCurso.ejecutar(comandoAsistenciaCruso);
    }
}
