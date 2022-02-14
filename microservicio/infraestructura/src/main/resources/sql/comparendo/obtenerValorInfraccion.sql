SELECT tt.valor FROM infraccion_tarifa it
INNER JOIN tipo_tarifa tt ON it.id_tipo_tarifa = tt.id_tipo_tarifa
WHERE it.id_tipo_infraccion = :tipoInfraccion