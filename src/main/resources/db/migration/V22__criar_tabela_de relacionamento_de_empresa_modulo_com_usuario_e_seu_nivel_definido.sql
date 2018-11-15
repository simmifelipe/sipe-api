CREATE TABLE usuario_empresa_modulo_nivel (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_empresa_modulo BIGINT(20) NOT NULL,
	nivel INT(11) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_empresa_modulo),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_empresa_modulo) REFERENCES empresa_modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (1, 1, 1);
insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (1, 2, 1);
insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (1, 3, 1);
insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (1, 4, 1);
insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (1, 5, 1);
insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (1, 6, 1);

insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (2, 9, 4);
insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (2, 6, 2);
insert into usuario_empresa_modulo_nivel(codigo_usuario, codigo_empresa_modulo, nivel) values (2, 8, 3);