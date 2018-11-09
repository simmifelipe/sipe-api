
CREATE TABLE item_estrutura (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	ativo BOOLEAN,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE item_estrutura_local_evento (
	codigo_local_evento BIGINT(20) NOT NULL,
	codigo_item_estrutura BIGINT(20) NOT NULL,
	observacoes VARCHAR(255) NULL, 
	PRIMARY KEY (codigo_local_evento, codigo_item_estrutura),
	FOREIGN KEY (codigo_local_evento) REFERENCES local_evento(codigo),
	FOREIGN KEY (codigo_item_estrutura) REFERENCES item_estrutura(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;