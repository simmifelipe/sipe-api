
CREATE TABLE empresa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(150) NOT NULL,
	cnpj BIGINT(20) NOT NULL,
	inscricao_municipal BIGINT(20) NULL,
	IE BIGINT(20) NULL,
	logradouro VARCHAR(80) NULL,
	bairro VARCHAR(40) NULL,
	cep VARCHAR(15) NULL,
	numero VARCHAR(10) NULL, 
	complemento VARCHAR(255) NULL,
	ativo BOOLEAN NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;