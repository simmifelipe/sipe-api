
ALTER TABLE cidade ADD nome VARCHAR(255) NOT NULL;
ALTER TABLE cidade ADD codigo_ibge BIGINT(20) NULL;
ALTER TABLE cidade ADD estado VARCHAR(50) NULL;
ALTER TABLE cidade ADD codigo_estado INT(11) NULL;
ALTER TABLE cidade ADD populacao BIGINT(20) NULL;
ALTER TABLE cidade ADD observacoes VARCHAR(255) NULL;