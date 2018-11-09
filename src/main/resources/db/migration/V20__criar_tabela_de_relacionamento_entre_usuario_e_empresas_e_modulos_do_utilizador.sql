CREATE TABLE empresa_modulo (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	codigo_empresa BIGINT(20) NOT NULL,
	codigo_modulo BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_empresa) REFERENCES empresa(codigo),
	FOREIGN KEY (codigo_modulo) REFERENCES modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (1, 1, 1);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (2, 1, 2);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (3, 2, 1);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (4, 2, 2);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (5, 3, 1);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (6, 3, 2);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (7, 4, 1);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (8, 4, 2);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (9, 5, 1);
insert into empresa_modulo(codigo, codigo_empresa, codigo_modulo) values (10, 5, 2);