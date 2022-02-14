package com.ceiba.comparendo.controlador;

import com.ceiba.comparendo.consulta.ManejadorListaComparendos;
import com.ceiba.comparendo.modelo.dto.DtoComparendo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comparendos")
@Api(tags={"Controlador consulta comparendos"})
public class ConsultaControladorComparendo {

    private final ManejadorListaComparendos manejadorListaComparendos;

    public ConsultaControladorComparendo(ManejadorListaComparendos manejadorListaComparendos) {
        this.manejadorListaComparendos = manejadorListaComparendos;
    }


    @GetMapping(value="/idInfractor/{identificacionInfractor}")
    @ApiOperation("Listar Comparendo por Infractor")
    public List<DtoComparendo> listarPorInfractor(@PathVariable String identificacionInfractor){
        return this.manejadorListaComparendos.ejecutar(identificacionInfractor);
    }

}
