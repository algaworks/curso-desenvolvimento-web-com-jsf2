create table usuario (
   nome_usuario varchar(15) not null primary key,
   senha varchar(15) not null
);

create table permissao_usuario (
   nome_usuario	varchar(15) not null,
   nome_permissao varchar(15) not null, 
   primary key (nome_usuario, nome_permissao),
   foreign key (nome_usuario) references usuario (nome_usuario)
);

insert into usuario values ('joao', 'joao');
insert into usuario values ('maria', 'maria');
insert into usuario values ('sebastiao', 'sebastiao');

insert into permissao_usuario values ('joao', 'cadastro');
insert into permissao_usuario values ('maria', 'consulta');
insert into permissao_usuario values ('sebastiao', 'cadastro');
insert into permissao_usuario values ('sebastiao', 'consulta');