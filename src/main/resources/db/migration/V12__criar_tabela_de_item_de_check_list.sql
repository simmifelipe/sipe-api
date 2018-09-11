
CREATE TABLE item_check_list (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(150) NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	codigo_tipo_item_check_list BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo),
	FOREIGN KEY (codigo_tipo_item_check_list) REFERENCES tipo_item_check_list(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;