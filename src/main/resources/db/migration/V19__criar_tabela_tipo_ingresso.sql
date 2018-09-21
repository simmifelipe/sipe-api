
CREATE TABLE tipo_ingresso (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	ativo BOOLEAN,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;