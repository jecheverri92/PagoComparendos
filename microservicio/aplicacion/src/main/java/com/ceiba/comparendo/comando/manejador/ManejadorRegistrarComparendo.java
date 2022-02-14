package com.ceiba.comparendo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comparendo.comando.ComandoComparendo;
import com.ceiba.comparendo.comando.fabrica.FabricaComparendo;
import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.servicio.ServicioCrearComparendo;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarComparendo implements ManejadorComandoRespuesta<ComandoComparendo, ComandoRespuesta<Long>> {

    private final ServicioCrearComparendo servicioCrearComparendo;
    private final FabricaComparendo fabricaComparendo;

    public ManejadorRegistrarComparendo(ServicioCrearComparendo servicioCrearComparendo, FabricaComparendo fabricaComparendo) {
        this.servicioCrearComparendo = servicioCrearComparendo;
        this.fabricaComparendo = fabricaComparendo;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoComparendo comandoComparendo) {
        Comparendo comparendo = this.fabricaComparendo.crear(comandoComparendo);
        return new ComandoRespuesta<>(this.servicioCrearComparendo.ejecutar(comparendo));
    }
}
