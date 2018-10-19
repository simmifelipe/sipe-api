
CREATE TABLE usuario (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	ativo BOOLEAN NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT
  INTO usuario
  (codigo_utilizador, codigo, nome, email, senha, ativo)
VALUES
  (1, 1, 'Administrador', 'admin@sipe.com', '$2a$10$rbqKm9EBHwlIqyOy3bdDw.1YBEZQ/EAMpTMh60d4Ydv84NfDu7Tza', 1);
