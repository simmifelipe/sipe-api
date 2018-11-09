
CREATE TABLE evento_item_check_list(
	codigo_evento BIGINT(20) NOT NULL,
	codigo_item_check_list BIGINT(20) NOT NULL,
	status VARCHAR(30) NULL,
	PRIMARY KEY (codigo_evento, codigo_item_check_list),
	FOREIGN KEY (codigo_evento) REFERENCES evento(codigo),
	FOREIGN KEY (codigo_item_check_list) REFERENCES item_check_list(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;