
CREATE TABLE ingresso_setor_evento (
	codigo_evento BIGINT(20) NOT NULL,
	codigo_setor_ingresso BIGINT(20) NOT NULL,
	codigo_tipo_ingresso BIGINT(20) NOT NULL,
	lote VARCHAR(50) NULL,
	valor DECIMAL(10, 2) NULL,
	quantidade BIGINT(20) NULL,
	quantidade_vendida BIGINT(20) NULL,
	PRIMARY KEY (codigo_evento, codigo_setor_ingresso, codigo_tipo_ingresso),
	FOREIGN KEY (codigo_evento) REFERENCES evento(codigo),
	FOREIGN KEY (codigo_setor_ingresso) REFERENCES setor_ingresso(codigo),
	FOREIGN KEY (codigo_tipo_ingresso) REFERENCES tipo_ingresso(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;