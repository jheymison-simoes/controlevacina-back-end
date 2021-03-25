create table users(
    id bigint not null auto_increment,
    name varchar(255) not null,
    email varchar(255) not null,
    cpf varchar(11) not null,
    date_birth varchar(10) not null,
    
    primary key(id)
);