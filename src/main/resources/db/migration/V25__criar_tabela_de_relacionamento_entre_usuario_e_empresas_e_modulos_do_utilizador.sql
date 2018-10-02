
CREATE TABLE usuario_empresa_modulo (
	codigo_usuario_utilizador BIGINT(20) NOT NULL,
	codigo_empresa BIGINT(20) NOT NULL,
	codigo_modulo BIGINT(20) NOT NULL,
	nivel INT(11) NOT NULL,
	PRIMARY KEY (codigo_usuario_utilizador, codigo_empresa, codigo_modulo),
	FOREIGN KEY (codigo_usuario_utilizador) REFERENCES usuario_utilizador(codigo),
	FOREIGN KEY (codigo_empresa) REFERENCES empresa(codigo),
	FOREIGN KEY (codigo_modulo) REFERENCES modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;