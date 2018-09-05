
CREATE TABLE tarefa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	status VARCHAR(30) NOT NULL,
	data_limite DATE NULL,
	custo DECIMAL(11,2) NULL,
	observacao VARCHAR(255) NULL,
	codigo_evento BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_evento) REFERENCES evento(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;