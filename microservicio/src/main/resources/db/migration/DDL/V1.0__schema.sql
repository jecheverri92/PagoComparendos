create table usuario (
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
 valor_comparendo float(9) UNSIGNED NOT NULL,
 primary key (id)
);

CREATE TABLE IF NOT EXISTS asistencia_curso (
	id_asistencia_curso int(11) not null auto_increment,
	identificacion_infractor varchar(100) not null,
	numero_comparendo varchar(100) not null,
	fecha_asistencia datetime not null,
	primary key (id_asistencia_curso)
);
-- Creacion tablas tipo
create table tipo_infraccion (
 id_tipo_infraccion int(11) not null,
 nombre_infraccion varchar(100) not null,
 primary key (id_tipo_infraccion)
);

create table tipo_tarifa (
 id_tipo_tarifa int(11) not null,
 valor float(9) UNSIGNED NOT null,
 primary key (id_tipo_tarifa)
);

create table infraccion_tarifa(
 id_tarifa_infraccion int(11) not null,
 id_tipo_infraccion int(11) not null,
 id_tipo_tarifa int(11) not null,
 foreign key(id_tipo_infraccion) references tipo_infraccion(id_tipo_infraccion),
 foreign key(id_tipo_tarifa) references tipo_tarifa(id_tipo_tarifa),
 primary key (id_tarifa_infraccion)
);