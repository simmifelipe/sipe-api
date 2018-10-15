
CREATE TABLE utilizador_modulo (
	codigo_utilizador BIGINT(20) NOT NULL,
	codigo_modulo BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_utilizador, codigo_modulo),
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo),
	FOREIGN KEY (codigo_modulo) REFERENCES modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;