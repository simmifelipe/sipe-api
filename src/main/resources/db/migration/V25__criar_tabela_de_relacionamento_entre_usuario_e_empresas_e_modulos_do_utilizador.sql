CREATE TABLE empresa_modulo (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	codigo_empresa BIGINT(20) NOT NULL,
	codigo_modulo BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_empresa) REFERENCES empresa(codigo),
	FOREIGN KEY (codigo_modulo) REFERENCES modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;