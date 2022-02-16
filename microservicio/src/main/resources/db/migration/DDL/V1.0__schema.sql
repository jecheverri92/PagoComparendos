CREATE TABLE IF NOT EXISTS usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE IF NOT EXISTS maestro_comparendo (
 id int(11) not null auto_increment,
 numero_comparendo varchar(100) not null,
 tipo_infraccion int not null,
 identificacion_infractor varchar(100) not null,
 fecha_comparendo datetime not null,
 valor_comparendo decimal(15,2) UNSIGNED NOT NULL,
 primary key (id)
);

CREATE TABLE IF NOT EXISTS asistencia_curso (
	id int(11) not null auto_increment,
	identificacion_infractor varchar(100) not null,
	numero_comparendo varchar(100) not null,
	fecha_asistencia datetime not null,
	primary key (id)
);
-- Creacion tablas tipo
CREATE TABLE IF NOT EXISTS tipo_infraccion (
 id_tipo_infraccion int(11) not null,
 nombre_infraccion varchar(100) not null,
 primary key (id_tipo_infraccion)
);

CREATE TABLE IF NOT EXISTS tipo_tarifa (
 id_tipo_tarifa int(11) not null,
 valor decimal(15,2) UNSIGNED NOT null,
 primary key (id_tipo_tarifa)
);

CREATE TABLE IF NOT EXISTS infraccion_tarifa(
 id_tarifa_infraccion int(11) not null,
 id_tipo_infraccion int(11) not null,
 id_tipo_tarifa int(11) not null,
 foreign key(id_tipo_infraccion) references tipo_infraccion(id_tipo_infraccion),
 foreign key(id_tipo_tarifa) references tipo_tarifa(id_tipo_tarifa),
 primary key (id_tarifa_infraccion)
);