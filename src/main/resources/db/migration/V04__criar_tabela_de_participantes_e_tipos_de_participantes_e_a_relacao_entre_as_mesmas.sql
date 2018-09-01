CREATE TABLE tipo_participante (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE participante (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(120) NOT NULL,
	nome_fantasia VARCHAR(120) NOT NULL,
	logradouro VARCHAR(80) NULL,
	bairro VARCHAR(40) NULL,
	cep VARCHAR(15) NULL,
	numero VARCHAR(10) NULL, 
	complemento VARCHAR(255) NULL,
	tipo_pessoa VARCHAR(20) NOT NULL,
	cpf_cnpj BIGINT(20) NOT NULL,
	ie BIGINT(20) NOT NULL,
	im BIGINT(20) NOT NULL,
	contato VARCHAR(120) NULL,
	telefone VARCHAR(30) NULL,
	email VARCHAR(120) NULL,
	observacoes VARCHAR(80) NULL,
	ativo BOOLEAN NOT NULL,
	codigo_cidade BIGINT(20) NOT NULL,
	codigo_utilizador BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo),
	FOREIGN KEY (codigo_utilizador) REFERENCES utilizador(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE participante_tipo_participante (
	codigo_participante BIGINT(20) NOT NULL,
	codigo_tipo_participante BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_participante, codigo_tipo_participante),
	FOREIGN KEY (codigo_participante) REFERENCES participante(codigo),
	FOREIGN KEY (codigo_tipo_participante) REFERENCES tipo_participante(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
