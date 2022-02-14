package com.ceiba.comparendo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comparendo.comando.ComandoComparendo;
import com.ceiba.comparendo.comando.ComandoPagarComparendo;
import com.ceiba.comparendo.comando.manejador.ManejadorPagarComparendo;
import com.ceiba.comparendo.comando.manejador.ManejadorRegistrarComparendo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comparendos")
@Api(tags = { "Controlador comando comparendo"})
public class ComandoControladorComparendo {

    private final ManejadorRegistrarComparendo manejadorRegistrarComparendo;
    private final ManejadorPagarComparendo manejadorPagarComparendo;

    public ComandoControladorComparendo(ManejadorRegistrarComparendo manejadorRegistrarComparendo, ManejadorPagarComparendo manejadorPagarComparendo) {
        this.manejadorRegistrarComparendo = manejadorRegistrarComparendo;
        this.manejadorPagarComparendo = manejadorPagarComparendo;
    }

    @PostMapping
    @ApiOperation("Crear Comparendo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoComparendo comandoComparendo) {
        return manejadorRegistrarComparendo.ejecutar(comandoComparendo);
    }

    @PutMapping(value="/pago")
    @ApiOperation("Pagar Comparendos")
    public void pagar(@RequestBody List<ComandoPagarComparendo> comandoPagarComparendo) {
        this.manejadorPagarComparendo.ejecutar(comandoPagarComparendo);
    }
}
