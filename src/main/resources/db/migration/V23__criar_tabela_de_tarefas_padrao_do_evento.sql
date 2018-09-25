
CREATE TABLE tarefa_template (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	tipo VARCHAR(30) NULL,
	periodo VARCHAR(100) NULL,
	ativo BOOLEAN NULL,
	codigo_cidade BIGINT(20) NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo),
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;