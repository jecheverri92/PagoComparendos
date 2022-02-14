package com.ceiba.comparendo.comando.manejador;

import com.ceiba.comparendo.comando.ComandoPagarComparendo;
import com.ceiba.comparendo.comando.fabrica.FabricaComparendo;
import com.ceiba.comparendo.modelo.dto.DtoPagoComparendo;
import com.ceiba.comparendo.servicio.ServicioPagarComparendo;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorPagarComparendo implements ManejadorComando<List<ComandoPagarComparendo>> {

    private final ServicioPagarComparendo servicioPagarComparendo;
    private final FabricaComparendo fabricaComparendo;


    public ManejadorPagarComparendo(ServicioPagarComparendo servicioPagarComparendo, FabricaComparendo fabricaComparendo) {
        this.servicioPagarComparendo = servicioPagarComparendo;
        this.fabricaComparendo = fabricaComparendo;
    }


    @Override
    public void ejecutar(List<ComandoPagarComparendo> comando) {
        List<DtoPagoComparendo> listaDtoPagoComparendos =  this.fabricaComparendo.pagarComparendo(comando);
        servicioPagarComparendo.ejecutar(listaDtoPagoComparendos);
    }

}
