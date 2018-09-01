CREATE TABLE cidade(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE utilizador (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(150) NOT NULL,
	cpf_cnpj BIGINT(20) NOT NULL,
	IE BIGINT(20) NULL,
	inscricao_municipal BIGINT(20) NULL,
	logradouro VARCHAR(80) NULL,
	bairro VARCHAR(40) NULL,
	cep VARCHAR(15) NULL,
	quantidade_filiais INT(5),
	acessos_permitidos INT(5),
	data_expiracao DATE NULL,
	ativo BOOLEAN NOT NULL,
	codigo_cidade BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;