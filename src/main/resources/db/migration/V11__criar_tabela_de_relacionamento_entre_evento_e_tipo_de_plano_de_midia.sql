
CREATE TABLE evento_plano_midia (
	codigo_evento BIGINT(20) NOT NULL,
	codigo_plano_midia BIGINT(20) NOT NULL,
	codigo_participante BIGINT(20) NOT NULL,
	spot BIGINT(20) NULL,
	valor DECIMAL(10,2) NULL,
	observacoes VARCHAR(255) NULL, 
	PRIMARY KEY (codigo_evento, codigo_plano_midia),
	FOREIGN KEY (codigo_evento) REFERENCES evento(codigo),
	FOREIGN KEY (codigo_plano_midia) REFERENCES plano_midia(codigo),
	FOREIGN KEY (codigo_participante) REFERENCES participante(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;