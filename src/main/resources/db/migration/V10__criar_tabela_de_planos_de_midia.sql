
CREATE TABLE plano_midia (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	ativo BOOLEAN NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;