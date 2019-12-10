create schema eSportDB;

use eSportDB;

create table utente(
	username varchar(36) primary key,
    password varchar(36) not null, 
    nome	varchar(36),
    cognome	varchar(36),
    email varchar(128),
    piva char(11),
    telefono char(10)
);

use eSportDB;

create table ruolo(
	usr varchar(36),
    permesso varchar(36),
    foreign key(usr) references utente(username)
		on update cascade
        on delete cascade
);

use eSportDB;

create table indirizzo(
	usr varchar(36),
    citta varchar(36),
    via varchar(36),
    civico varchar(12),
    cap varchar(5),
    foreign key(usr) references utente(username)
		on update cascade
        on delete cascade
);

use eSportDB;

create table metodopagamento(
	usr varchar(36),
    tipo varchar(36),
    numero varchar(36),
    foreign key(usr) references utente(username)
		on update cascade
        on delete cascade
);

use eSportDB;

create table prodotto(
	codice char(3) primary key,
    nome varchar(36) not null,
    tipo varchar(36) not null,
    marca varchar(36),
    qt int,
    prezzo double,
    iva int,
    descrizione varchar(512)
);

use eSportDB;

create table ordine(
	numero char(3) primary key,
    stato varchar(36),
    totale double not null,
    data date not null,
    consegna date,
    usr varchar(36) not null ,
    foreign key(usr) references utente(username)
		on update cascade
        on delete cascade
);

use eSportDB;

create table composizione(
	ordine char(3) not null,
    prodotto char(3),
    nomeprodotto varchar(36) not null,
    prezzoven double not null,
    ivaven int not null,
    qt int default 1,
    foreign key(ordine) references ordine(numero)
		on update cascade
        on delete cascade,
	foreign key(prodotto) references prodotto(codice)
		on update cascade
        on delete set null
);

use eSportDB;

create table recensione(
	codice int primary key auto_increment,
    voto int not null,
    commento varchar(512) not null,
    usr varchar(36),
    passutente varchar(36) not null, 
    prodotto char(3) not null,
    foreign key(usr) references utente(username)
		on update cascade
		on delete cascade,
	foreign key(prodotto) references prodotto(codice)
		on update cascade
        on delete cascade
);