package com.ceiba.comparendo.comando.fabrica;

import com.ceiba.comparendo.comando.ComandoComparendo;
import com.ceiba.comparendo.comando.ComandoPagarComparendo;
import com.ceiba.comparendo.modelo.dto.DtoPagoComparendo;
import com.ceiba.comparendo.modelo.entidad.Comparendo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaComparendo {

    public Comparendo crear(ComandoComparendo comandoComparendo){
        return new Comparendo(comandoComparendo.getId(),
                comandoComparendo.getNumeroComparendo(),
                comandoComparendo.getTipoInfraccion(),
                comandoComparendo.getIdentificacionInfractor(),
                comandoComparendo.getFechaComparendo(),
                comandoComparendo.getValorComparendo(),
                comandoComparendo.getPagado());
    }

    public List<DtoPagoComparendo> pagarComparendo(List<ComandoPagarComparendo> comandoPagarComparendos){
        List<DtoPagoComparendo> dtoComparendos = new ArrayList<>();
        comandoPagarComparendos.stream().forEach(comandoPagarComparendo -> {
            dtoComparendos.add(new DtoPagoComparendo(comandoPagarComparendo.getNumeroComparendo(),
                    comandoPagarComparendo.getValorPagado()));

        });
    return dtoComparendos;
    }
}
