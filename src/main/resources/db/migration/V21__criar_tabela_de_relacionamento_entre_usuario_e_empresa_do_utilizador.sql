
CREATE TABLE utilizador_usuario (
	codigo_utilizador BIGINT(20) NOT NULL,
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_empresa BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_utilizador, codigo_usuario, codigo_empresa),
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_empresa) REFERENCES empresa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;