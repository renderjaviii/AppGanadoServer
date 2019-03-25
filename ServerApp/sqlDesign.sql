create table Lot(
	id serial,
	name varchar(255),
	primary key(id)
);
create table Breed(
	id serial,
	name varchar(255),
	primary key(id)
);
create table Purpose(
	id serial,
	name varchar(255),
	primary key(id)
);
create table Gender(
	id serial,
	name varchar(255),
	primary key(id)
);


create table Rol(
	id serial,
	name varchar(255),
	primary key(id)
);

create table User_App(
	phone BIGINT,
	password varchar(255),
	id_Rol integer REFERENCES Rol(id) ON DELETE CASCADE ON UPDATE CASCADE,
	name varchar(255),
	email varchar(255),
	photo bytea,
	primary key(phone)
);

create table Estate(
	id serial,
	name varchar(255),
	location varchar(255),
	photo bytea,
	area float,
	phone_User BIGINT REFERENCES User_App(phone) ON DELETE CASCADE ON UPDATE CASCADE,
	primary key(id)
);


create table Cattle(
	id serial,
	code integer,
	name varchar(255),
	id_Lot integer REFERENCES Lot(id) ON DELETE CASCADE ON UPDATE CASCADE,
	id_Breed integer REFERENCES Breed(id) ON DELETE CASCADE ON UPDATE CASCADE,
	id_Purpose integer REFERENCES Purpose(id) ON DELETE CASCADE ON UPDATE CASCADE,
	id_Gender integer REFERENCES Gender(id) ON DELETE CASCADE ON UPDATE CASCADE, 
	id_Estate integer REFERENCES Estate(id) ON DELETE CASCADE ON UPDATE CASCADE, 
	age integer,
	weight float,
	photo bytea,
	details Varchar(255),
	primary key(id)
);


create table Event_Type(
	id serial,
	name varchar(255),
	primary key(id)
);


create table Event(
	id serial,
	id_Estate integer REFERENCES Estate(id) ON DELETE CASCADE ON UPDATE CASCADE,
	date_ date,
	id_Event_Type integer REFERENCES Event_Type(id) ON DELETE CASCADE ON UPDATE CASCADE,
	name varchar(255),
	details varchar(255),
	manager varchar(255),
	primary key(id)
);

create table Backup(
	id serial,
	date_ date,
	phone_User integer REFERENCES User_App(phone) ON DELETE CASCADE ON UPDATE CASCADE,
	primary key(id)
);

create table Tank(
	id serial,
	id_Estate integer REFERENCES Estate(id) ON DELETE CASCADE ON UPDATE CASCADE,
	name varchar(255),
	capacity float,
	primary key(id)
);

create table History_Type(
	id serial,
	phone_User integer REFERENCES User_App(phone) ON DELETE CASCADE ON UPDATE CASCADE,
	name varchar(255),
	primary key(id)
);


create table Cattle_History_Book(
	id serial,
	id_Cattle integer REFERENCES Cattle(id) ON DELETE CASCADE ON UPDATE CASCADE,
	id_History_Type integer REFERENCES History_Type(id) ON DELETE CASCADE ON UPDATE CASCADE,
	nameHistory varchar(255),
	date_ date,
	details varchar(255),
	primary key(id)
);

create table Production_Book(
	id serial,
	id_Tank integer REFERENCES Tank(id) ON DELETE CASCADE ON UPDATE CASCADE,
	date_ date,
	production float,
	primary key(id)
);


ALTER TABLE cattle ADD CONSTRAINT unique_cattle UNIQUE (code, id_estate);
ALTER TABLE estate ADD CONSTRAINT unque_estate UNIQUE(phone_user, name)
