
CREATE TABLE evento (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(120) NOT NULL,
	data_hora DATETIME NULL,
	duracao INTEGER NULL,
	status VARCHAR(50) NULL,
	codigo_cidade BIGINT(20) NOT NULL,
	codigo_empresa BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo),
	FOREIGN KEY (codigo_empresa) REFERENCES empresa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE evento_participante (
	codigo_evento BIGINT(20) NOT NULL,
	codigo_participante BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_evento, codigo_participante),
	FOREIGN KEY (codigo_evento) REFERENCES evento(codigo),
	FOREIGN KEY (codigo_participante) REFERENCES participante(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;