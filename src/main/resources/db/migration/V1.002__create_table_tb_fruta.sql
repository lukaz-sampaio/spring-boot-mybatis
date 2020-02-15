CREATE TABLE pgd.tb_fruta (
id serial primary key,
nome varchar(20) unique,
nome_cientifico varchar(80)
);

CREATE TABLE pgd.tb_familia_fruta(
id serial primary key,
nome varchar(20) unique
);

ALTER TABLE pgd.tb_fruta ADD COLUMN id_familia bigint;
ALTER TABLE pgd.tb_fruta ADD CONSTRAINT tb_familia_fruta_fk FOREIGN KEY (id_familia) REFERENCES pgd.tb_familia_fruta(id);

