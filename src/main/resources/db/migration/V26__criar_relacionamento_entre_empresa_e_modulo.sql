
CREATE TABLE empresa_modulo (
	codigo_empresa BIGINT(20) NOT NULL,
	codigo_modulo BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_empresa, codigo_modulo),
	FOREIGN KEY (codigo_empresa) REFERENCES empresa(codigo),
	FOREIGN KEY (codigo_modulo) REFERENCES modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;