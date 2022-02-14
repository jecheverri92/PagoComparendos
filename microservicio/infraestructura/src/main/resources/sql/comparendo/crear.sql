insert into maestro_comparendo (
    numero_comparendo,
    tipo_infraccion,
    identificacion_infractor,
    fecha_comparendo,
    valor_comparendo,
    pagado)
    values (:numeroComparendo, :tipoInfraccion, :identificacionInfractor,:fechaComparendo, :valorComparendo, :pagado)