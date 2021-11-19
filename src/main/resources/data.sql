CREATE TABLE company (
	id bigint primary key auto_increment,
	corporate varchar(200), 
	cnpj varchar(14),
	email varchar(200), 
	quantity varchar(200), 
	product varchar(200), 
	contact varchar(11)	
);

INSERT INTO company (
	corporate, 
	cnpj, 
	email, 
	quantity, 
	product, 
	contact
) 
VALUES (
	'Boticario', 
	'95609788000144',
	'cobranca@biancaepriscilaentregasexpressasme.com.br',
	'55',
	'Arroz',
	'15996801643'
);

INSERT INTO company (
	corporate, 
	cnpj, 
	email, 
	quantity, 
	product, 
	contact
)
VALUES (
	'Elias e Marcela Doces e Salgados ME', 
	'32181461000102',
	'pesquisa@eliasemarceladocessalgadosme.com.br',
	'45',
	'Feijão',
	'19989082303'
);

INSERT INTO company (
	corporate, 
	cnpj, 
	email, 
	quantity, 
	product, 
	contact
) 
VALUES (
	'Isabelle e Olivia Lavanderia ME', 
	'94158427000166',
	'desenvolvimento@isabelleeolivialavanderiame.com.br',
	'65',
	'Leite',
	'15983424050'
);

CREATE TABLE usuario (
	id bigint primary key auto_increment,
	name varchar(200),
	email varchar(200),
	password varchar(200)
);

INSERT INTO usuario (name, email, password) VALUES(
	'Adriana Nicole Maya Cavalcanti',
	'adriananicolemayacavalcanti@picolotoengenharia.com.br',
	'$2a$12$zEN4Ny.5uCI1XNhg7a784uVlmA53QtwJsvz8II57esVk2YtEqa74.'
);

INSERT INTO usuario (name, email, password) VALUES(
	'Nair Jaqueline da Cunha',
	'nairjaquelinedacunha@cordeiromaquinas.com.br',
	'$2a$12$WWa2QwennPrnUqIt8.htLeSBEgprKqdRnl.PxDhb4UFzMBfNIqfZe'
);

INSERT INTO usuario (name, email, password) VALUES(
	'Nathan Raimundo Nascimento',
	'nnathanraimundonascimento@vetech.vet.br',
	'$2a$12$YpNsoIuRPf5OVmA8pi2Gpe/lSO0y2NveWSZ3mj6CUOnuzCfN0Lq3O'
);

INSERT INTO usuario (name, email, password) VALUES(
	'Tomás Julio Brito',
	'tomasjuliobrito_@pronursing.com.br',
	'$2a$12$RD00adDxpxAcIixtWxSBz.Z.zOFMQO5xcmPKy1zf221SsTiHlOZ.6'
);

INSERT INTO usuario (name, email, password) VALUES(
	'Teste',
	'teste@teste.com',
	'$2a$12$9j.0D3ps2KiGFBtKxvaKA.FmqRvvZwNVyxgqTfAL/F9JHCuWegRc.'
);
