create table vaccinations(
	id bigint not null auto_increment,
    name_vaccine varchar(255) not null,
    date_vaccination varchar(10) not null,
    email_user varchar(255) not null,
    
    primary key(id)
);