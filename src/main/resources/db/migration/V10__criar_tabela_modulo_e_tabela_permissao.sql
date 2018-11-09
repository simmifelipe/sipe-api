
CREATE TABLE modulo (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into modulo(codigo, descricao) values (1, 'Eventos');
insert into modulo(codigo, descricao) values (2, 'Financeiro');

CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	nivel INT(11) NOT NULL,
	codigo_modulo BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_modulo) REFERENCES modulo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into permissao(codigo, descricao, nivel, codigo_modulo) values (1, 'ROLE_CADASTRAR_EMPRESA', 2, 1);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (2, 'ROLE_LISTAR_EMPRESA', 2, 1);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (3, 'ROLE_CADASTRAR_UTILIZADOR', 1, 1);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (4, 'ROLE_LISTAR_UTILIZADOR', 1, 1);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (5, 'ROLE_CADASTRAR_USUARIO', 2, 1);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (6, 'ROLE_LISTAR_USUARIO', 2, 1);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (7, 'ROLE_CADASTRAR_DESPESA', 4, 2);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (8, 'ROLE_ALTERAR_DESPESA', 3, 2);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (9, 'ROLE_LISTAR_DESPESA', 4, 2);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (10, 'ROLE_CADASTRAR_PARTICIPANTE', 4, 1);
insert into permissao(codigo, descricao, nivel, codigo_modulo) values (11, 'ROLE_LISTAR_PARTICIPANTE', 4, 1);