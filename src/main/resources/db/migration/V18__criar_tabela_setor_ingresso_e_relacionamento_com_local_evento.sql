
CREATE TABLE setor_ingresso (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	ativo BOOLEAN,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE setor_ingresso_local_evento (
	codigo_local_evento BIGINT(20) NOT NULL,
	codigo_setor_ingresso BIGINT(20) NOT NULL,
	capacidade BIGINT(20) NULL,
	observacoes VARCHAR(255) NULL, 
	PRIMARY KEY (codigo_local_evento, codigo_setor_ingresso),
	FOREIGN KEY (codigo_local_evento) REFERENCES local_evento(codigo),
	FOREIGN KEY (codigo_setor_ingresso) REFERENCES setor_ingresso(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;