CREATE TABLE usuario_empresa_modulo_nivel (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_empresa_modulo BIGINT(20) NOT NULL,
	nivel INT(11) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_empresa_modulo),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_empresa_modulo) REFERENCES empresa_modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;