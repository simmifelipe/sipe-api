
CREATE TABLE local_evento (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(150) NOT NULL,
	responsavel VARCHAR(150) NULL,
	telefone VARCHAR(20) NULL,
	capacidade BIGINT(20) NULL,
	observacoes VARCHAR(255) NULL,
	codigo_cidade BIGINT(20) NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo),
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;