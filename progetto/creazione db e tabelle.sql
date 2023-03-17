-- CREATE DATABASE veterinario;
CREATE TABLE utente (
username varchar(25),
password varchar(25) not null,
admin boolean not null,
primary key(username)
);
Create  table animale(
nome varchar(25) not null,
tipo enum('cane','gatto','criceto','topo','scoiattolo','maiale')not null,
idAnimale bigint,
annoNascita int,
primary key(idAnimale)
);

CREATE TABLE prenotazione(
utente varchar(25) not null,
dataPrenotazione date not null,
idAnimale int not null,
diagnosiAnimale varchar(500),
idPrenotazione bigint,
primary key (idPrenotazione),
foreign key (utente) references utente (username),
foreign key(idAnimale) references animale(idAnimale)
)