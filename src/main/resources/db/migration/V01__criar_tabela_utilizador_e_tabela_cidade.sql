CREATE TABLE cidade(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	codigo_ibge BIGINT(20) NULL,
	estado VARCHAR(50) NULL,
	codigo_estado INT(11) NULL,
	populacao BIGINT(20) NULL,
	observacoes VARCHAR(255) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cidade (codigo, nome, codigo_ibge, estado, codigo_estado, populacao, observacoes) values (1, 'Salvador do Sul', 135221, 'RS', 43, 7500, '');
INSERT INTO cidade (codigo, nome, codigo_ibge, estado, codigo_estado, populacao, observacoes) values (2, 'Barão', 135221, 'RS', 43, 4605, '');
INSERT INTO cidade (codigo, nome, codigo_ibge, estado, codigo_estado, populacao, observacoes) values (3, 'São Pedro da Serra', 54212, 'RS', 43, 6325, '');
INSERT INTO cidade (codigo, nome, codigo_ibge, estado, codigo_estado, populacao, observacoes) values (4, 'Tupandi', 53212, 'RS', 43, 7021, '');
INSERT INTO cidade (codigo, nome, codigo_ibge, estado, codigo_estado, populacao, observacoes) values (5, 'São José do Sul', 32541, 'RS', 43, 2351, '');


CREATE TABLE utilizador (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(150) NOT NULL,
	cpf_cnpj BIGINT(20) NOT NULL,
	IE BIGINT(20) NULL,
	inscricao_municipal BIGINT(20) NULL,
	logradouro VARCHAR(80) NULL,
	bairro VARCHAR(40) NULL,
	cep VARCHAR(15) NULL,
	numero VARCHAR(10) NULL,
	complemento VARCHAR(255) NULL,
	quantidade_filiais INT(5),
	acessos_permitidos INT(5),
	data_expiracao DATE NULL,
	ativo BOOLEAN NOT NULL,
	codigo_cidade BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into utilizador (codigo, nome, cpf_cnpj, logradouro, bairro, quantidade_filiais, acessos_permitidos, ativo, codigo_cidade) values (1, 'G3 Softwares', 01852042211, 'Av. Duque de Caxias', 'Centro', 1, 5, true, 1);
insert into utilizador (codigo, nome, cpf_cnpj, logradouro, bairro, quantidade_filiais, acessos_permitidos, ativo, codigo_cidade) values (2, 'Artistaria', 06523154287, 'Av. das Flores', 'Vila Nova', 1, 16, true, 4);
