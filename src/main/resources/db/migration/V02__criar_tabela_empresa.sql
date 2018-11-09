
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

insert into empresa(codigo, nome, cnpj, ativo, codigo_utilizador) values (1, 'Produtora de Eventos #1', 91362590004215, true, 1);
insert into empresa(codigo, nome, cnpj, ativo, codigo_utilizador) values (2, 'Produtora de Eventos #2', 91362590007326, true, 1);
insert into empresa(codigo, nome, cnpj, ativo, codigo_utilizador) values (3, 'Produtora de Eventos #3', 91362590000408, true, 1);
insert into empresa(codigo, nome, cnpj, ativo, codigo_utilizador) values (4, 'Produtora de Eventos #4', 91362590003505, true, 2);
insert into empresa(codigo, nome, cnpj, ativo, codigo_utilizador) values (5, 'Produtora de Eventos #5', 91362590000409, true, 2);