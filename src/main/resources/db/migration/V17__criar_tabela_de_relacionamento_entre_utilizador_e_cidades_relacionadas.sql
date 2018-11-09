
CREATE TABLE utilizador_cidade_cidade_relacionada (
	codigo_utilizador BIGINT(20) NOT NULL,
	codigo_cidade BIGINT(20) NOT NULL,
	codigo_cidade_relacionada BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_utilizador, codigo_cidade, codigo_cidade_relacionada),
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo),
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo),
	FOREIGN KEY (codigo_cidade_relacionada) REFERENCES cidade(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;