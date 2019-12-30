/* 1. Inserimento prodotti */

insert into prodotto(codice, nome, tipo, marca, qt, prezzo, iva, descrizione)
values('001', 'Divisa Home Real Madrid', 'Divisa', 'Adidas', 34, 99.99, 22, 
	   'Divisa Home Real Madrid 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Real Madrid'
       );
       
insert into prodotto(codice, nome, tipo, marca, qt, prezzo, iva, descrizione)
values('002', 'Mercurial Vapor', 'Scarpe', 'Nike', 44, 99.99, 22, 
	   'Scarpe Nike Mercurial Vapor. Serie Mercurial 2018/2019'
       );
       
insert into prodotto(codice, nome, tipo, marca, qt, prezzo, iva, descrizione)
values('003', 'Divisa Away Napoli', 'Divisa', 'Kappa', 54, 89.99, 22, 
	   'Divisa Away Napoli 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Napoli'
       );
       
insert into prodotto(codice, nome, tipo, marca, qt, prezzo, iva, descrizione)
values('005', 'Divisa Home Juventus', 'Divisa', 'Nike', 64, 99.99, 22, 
	   'Divisa Home Juventus 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Juventus'
       );

insert into prodotto(codice, nome, tipo, marca, qt, prezzo, iva, descrizione)
values('006', 'Divisa Away Inter', 'Divisa', 'Nike', 64, 99.99, 22, 
	   'Divisa Away Inter 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Inter'
       );
       
insert into prodotto(codice, nome, tipo, marca, qt, prezzo, iva, descrizione)
values('012', 'Pantaloni Home Real Madrid', 'Pantaloncini', 'Adidas', 24, 49.99, 22, 
	   'Pantaloncini ufficiali della stagione 2018/2019 della squadra calcistica Real Madrid'
       );
       
insert into prodotto(codice, nome, tipo, marca, qt, prezzo, iva, descrizione)
values('013', 'Pantaloni Home Juventus', 'Pantaloncini', 'Adidas', 24, 49.99, 22, 
	   'Pantaloncini ufficiali della stagione 2018/2019 della squadra calcistica Juventus'
       );
       
/* 2. Inserimento taglie */

insert into taglia(prodotto, misura)
values('001', 'S');

insert into taglia(prodotto, misura)
values('001', 'M');

insert into taglia(prodotto, misura)
values('001', 'L');

insert into taglia(prodotto, misura)
values('002', '38');

insert into taglia(prodotto, misura)
values('002', '40');

insert into taglia(prodotto, misura)
values('002', '42');

insert into taglia(prodotto, misura)
values('003', 'S');

insert into taglia(prodotto, misura)
values('003', 'M');

insert into taglia(prodotto, misura)
values('003', 'L');

insert into taglia(prodotto, misura)
values('005', 'S');

insert into taglia(prodotto, misura)
values('005', 'M');

insert into taglia(prodotto, misura)
values('005', 'L');

insert into taglia(prodotto, misura)
values('006', 'S');

insert into taglia(prodotto, misura)
values('006', 'M');

insert into taglia(prodotto, misura)
values('006', 'L');

insert into taglia(prodotto, misura)
values('012', 'S');

insert into taglia(prodotto, misura)
values('012', 'M');

insert into taglia(prodotto, misura)
values('012', 'L');

insert into taglia(prodotto, misura)
values('013', 'S');

insert into taglia(prodotto, misura)
values('013', 'M');

insert into taglia(prodotto, misura)
values('013', 'L');
        
/* 3. Inserimento utente */

insert into utente(username, pwd, nome, cognome, email, piva, telefono)
values('root', 'root', 'Amministratore', 'globale', 'root@esport.com', '26143279428', '3382771680');
       
insert into utente(username, pwd, nome, cognome, email, piva, telefono)
values('CarloRaucci', 'carloraucci', 'Carlo', 'Raucci', 'carlo.raucci@hotmail.com', '21652126438', '3281771560');
 
/* 4. Inserimento recensione */

insert into recensione(voto, commento, usr, prodotto)
values(9, 'Soddisfatto del mio acquisto, il sito è affidabile e la divisa è arrivata in ottime condizioni',
		'CarloRaucci', '001');
        
insert into recensione(voto, commento, usr, prodotto)
values(8, 'Soddisfatto del mio acquisto, sicuramente acquisterò in fututo. Consigliato.',
		'CarloRaucci', '005');
        
/* 5. Inserimento ruolo */

insert into ruolo(usr, permesso)
values('root', 'Utente');

insert into ruolo(usr, permesso)
values('root', 'Catalogo');

insert into ruolo(usr, permesso)
values('root', 'Ordini');

insert into ruolo(usr, permesso)
values('CarloRaucci', 'Utente');

/* 6. Inserimento indirizzo */

insert into indirizzo(usr, citta, via, civico, cap)
values('root', 'Salerno', 'Via San Marzano', '83', '84096');

insert into indirizzo(usr, citta, via, civico, cap)
values('root', 'Caserta', 'Via Angelo Preziosi', '46', '84096');

insert into indirizzo(usr, citta, via, civico, cap)
values('CarloRaucci', 'Campobasso', 'Via San Citro', '78', '84096');

/* 7. Inserimento metodi di pagamento recensione*/

insert into metodopagamento(usr, tipo, numero)
values('root', 'Postepay', '1378134767340924');

insert into metodopagamento(usr, tipo, numero)
values('root', 'Postepay', '1478126267340911');

insert into metodopagamento(usr, tipo, numero)
values('CarloRaucci', 'Postepay', '1578121567340931');

