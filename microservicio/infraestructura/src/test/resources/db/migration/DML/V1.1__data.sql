insert into usuario(id, nombre,clave,fecha_creacion)
values(1,'test','1234',now());


--se configuran tarifas
insert into tipo_infraccion(id_tipo_infraccion,nombre_infraccion)
values(1,'Ecxeso de Velocidad');
insert into tipo_infraccion(id_tipo_infraccion,nombre_infraccion)
values(2,'Pasarse Semaforo en Rojo');
insert into tipo_infraccion(id_tipo_infraccion,nombre_infraccion)
values(3,'Tecnico-Mecanica vencida');

insert into tipo_tarifa(id_tipo_tarifa, valor)
values(1,100000);
insert into tipo_tarifa(id_tipo_tarifa, valor)
values(2,200000);
insert into tipo_tarifa(id_tipo_tarifa, valor)
values(3,300000);

insert into infraccion_tarifa(id_tarifa_infraccion, id_tipo_infraccion, id_tipo_tarifa)
values(1,1,1);
insert into infraccion_tarifa(id_tarifa_infraccion, id_tipo_infraccion, id_tipo_tarifa)
values(2,2,2);
insert into infraccion_tarifa(id_tarifa_infraccion, id_tipo_infraccion, id_tipo_tarifa)
values(3,3,3);

--Comparendos con el mismo idInfractor
insert into maestro_comparendo(
id,numero_comparendo,tipo_infraccion,identificacion_infractor,fecha_comparendo,valor_comparendo)
values(1,'0001',1,'123456789','1986-04-08', 1000);
insert into maestro_comparendo(
id,numero_comparendo,tipo_infraccion,identificacion_infractor,fecha_comparendo,valor_comparendo)
values(2,'0002',1,'123456789','1986-04-08', 1000);


