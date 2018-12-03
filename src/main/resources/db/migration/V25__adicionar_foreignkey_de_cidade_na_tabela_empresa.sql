
ALTER TABLE empresa ADD CONSTRAINT id_fk_cidade
FOREIGN KEY(codigo_cidade) REFERENCES cidade(codigo);