
ALTER TABLE empresa ADD COLUMN telefone VARCHAR(30) NULL AFTER numero;
ALTER TABLE empresa ADD COLUMN email VARCHAR(150) NULL AFTER telefone;
ALTER TABLE empresa ADD COLUMN codigo_cidade BIGINT(20) NOT NULL DEFAULT 1 AFTER codigo_utilizador;