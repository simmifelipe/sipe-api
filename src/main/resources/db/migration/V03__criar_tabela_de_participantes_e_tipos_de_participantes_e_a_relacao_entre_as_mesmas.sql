CREATE TABLE tipo_participante (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tipo_participante(codigo, descricao) values (1, 'Fornecedor');
insert into tipo_participante(codigo, descricao) values (2, 'Cliente');
insert into tipo_participante(codigo, descricao) values (3, 'Transportadora');

CREATE TABLE participante (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(120) NOT NULL,
	nome_fantasia VARCHAR(120) NULL,
	logradouro VARCHAR(80) NULL,
	bairro VARCHAR(40) NULL,
	cep VARCHAR(15) NULL,
	numero VARCHAR(10) NULL, 
	complemento VARCHAR(255) NULL,
	tipo_pessoa VARCHAR(20) NOT NULL,
	cpf_cnpj BIGINT(20) NOT NULL,
	ie BIGINT(20) NULL,
	im BIGINT(20) NULL,
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

insert into participante(codigo, nome, tipo_pessoa, cpf_cnpj, ativo, codigo_cidade, codigo_utilizador) values (1, 'SW Transportadora', 'JURIDICA', 91362590003652, true, 2, 1);
insert into participante(codigo, nome, tipo_pessoa, cpf_cnpj, ativo, codigo_cidade, codigo_utilizador) values (2, 'Facebook SA', 'JURIDICA', 91362590006541, true, 4, 1);
insert into participante(codigo, nome, tipo_pessoa, cpf_cnpj, ativo, codigo_cidade, codigo_utilizador) values (3, 'Grafica TK', 'JURIDICA', 91362590004512, true, 1, 2);
insert into participante(codigo, nome, tipo_pessoa, cpf_cnpj, ativo, codigo_cidade, codigo_utilizador) values (4, 'Cris Pereira', 'FISICA', 05625142255, true, 3, 2);


CREATE TABLE participante_tipo_participante (
	codigo_participante BIGINT(20) NOT NULL,
	codigo_tipo_participante BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_participante, codigo_tipo_participante),
	FOREIGN KEY (codigo_participante) REFERENCES participante(codigo),
	FOREIGN KEY (codigo_tipo_participante) REFERENCES tipo_participante(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into participante_tipo_participante(codigo_participante, codigo_tipo_participante) values (1, 3);
insert into participante_tipo_participante(codigo_participante, codigo_tipo_participante) values (2, 1);
insert into participante_tipo_participante(codigo_participante, codigo_tipo_participante) values (3, 1);
insert into participante_tipo_participante(codigo_participante, codigo_tipo_participante) values (4, 2);