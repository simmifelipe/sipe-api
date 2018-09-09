
CREATE TABLE usuario_utilizador (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	ativo BOOLEAN NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;