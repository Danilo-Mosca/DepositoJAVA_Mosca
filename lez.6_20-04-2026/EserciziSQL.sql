/* 1) Utilizzo di DISTINCT e WHERE
Elencare, senza ripetizioni, tutte le regioni (Region) dei paesi che appartengono alcontinente (Continent) 'Europe':
*/
SELECT DISTINCT Region
FROM country
WHERE Continent = 'Europe';

/* 2) Elenca i Nomi (Name) e Popolazioni (Population) dei paesi del Sud Europa (Southern Europe) la quale popolazione è maggiore a 25000: */
SELECT Name, Population FROM country
WHERE Region = 'Southern Europe' AND Population > 25000
ORDER BY Population ASC;

/* 3) GROUP BY con funzioni di aggregazione
Mostrare per ogni continente (Continent) presente nella tabella Country:
- Il numero totale di paesi appartenenti a ciascun continente.
- La popolazione totale del continente:
Ordinare il risultato per popolazione totale in ordine decrescente */
SELECT Continent,COUNT(Name), SUM(Population) AS Popolazione_Totale
FROM country
GROUP BY Continent
ORDER BY Popolazione_Totale ASC;




/* ESERCIZIO
Si consideri una tabella chiamata Vendite con la seguente struttura, almeno 20 elementi generati:

Vendite (
	id INT,
	prodotto VARCHAR(100),
	categoria VARCHAR(50),
	quantita INT,
	prezzo_unitario DECIMAL(6,2),
	data_vendita DATE
)
*/

/* Prima creo il database "negozio" e la relativa tabella "Vendite": */
CREATE DATABASE negozio;

USE negozio; 

CREATE TABLE vendite(
	id INT,
    prodotto VARCHAR(100),
    categoria VARCHAR(50),
    quantita INT,
    prezzo_unitario DECIMAL(6,2),
    data_vendita DATE
);

/* Poi popolo il database con i seguenti dati: */
USE negozio;

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) VALUES
(1, 'MacBook Air M2', 'Elettronica', 1, 1199.00, '2026-01-10'),
(2, 'iPhone 14', 'Elettronica', 2, 899.00, '2026-01-11'),
(3, 'Samsung Galaxy S23', 'Elettronica', 1, 849.99, '2026-01-12'),
(4, 'Nike Air Force 1', 'Abbigliamento', 3, 110.00, '2026-01-12'),
(5, 'Adidas Hoodie', 'Abbigliamento', 2, 65.50, '2026-01-13'),
(6, 'Scrivania Gaming', 'Arredamento', 1, 199.90, '2026-01-14'),
(7, 'Sedia Ergonomica', 'Arredamento', 1, 149.99, '2026-01-14'),
(8, 'Mouse Logitech MX Master 3', 'Elettronica', 2, 99.99, '2026-01-15'),
(9, 'Tastiera Meccanica', 'Elettronica', 1, 129.90, '2026-01-15'),
(10, 'Borraccia Termica', 'Accessori', 4, 19.90, '2026-01-16'),
(11, 'Zaino da lavoro', 'Accessori', 1, 59.99, '2026-01-16'),
(12, 'Monitor 27 pollici', 'Elettronica', 1, 279.00, '2026-01-17'),
(13, 'Cuffie Bluetooth', 'Elettronica', 2, 79.90, '2026-01-18'),
(14, 'Libro React Avanzato', 'Libri', 3, 39.90, '2026-01-18'),
(15, 'Lampada LED Scrivania', 'Arredamento', 2, 24.90, '2026-01-19');


/* Scrivi le query SQL per rispondere alle seguenti richieste: */

/* - Totale vendite per categoria: visualizza, per ogni categoria, il numero totale di vendite effettuate */
SELECT  categoria, SUM(quantita * prezzo_unitario) AS Totale_Vendite_Per_Categorie
FROM Vendite
GROUP BY categoria;

/* - Prezzo medio per categoria: mostra, per ogni categoria, il prezzo medio dei prodotti venduti */
SELECT  categoria, SUM(quantita * prezzo_unitario) / SUM(quantita) AS Prezzo_medio_prodotti_venduti
FROM Vendite
GROUP BY categoria;

/* - Quantità totale venduta per ogni prodotto: mostra il totale delle quantità vendute (SUM) per ciascun prodotto */
SELECT prodotto, SUM(quantita) AS Quantità_vendute
FROM vendite
GROUP BY prodotto;

/* - Prezzo massimo e minimo venduto nella tabella: mostra il prezzo massimo e il prezzo minimo tra tutti i prodotti venduti */
SELECT MAX(prezzo_unitario) AS Prezzo_Max, MIN(prezzo_unitario) AS Prezzo_Min 
FROM vendite;

/* - Numero totale di righe nella tabella: conta quante vendite sono state registrate nella tabella Vendite */
SELECT COUNT(id) AS Numero_vendite_registrate
FROM vendite;

/* - I 5 prodotti più costosi (in base al prezzo_unitario): elenca i 5 prodotti più costosi ordinati in modo decrescente rispetto al prezzo */
SELECT prodotto, prezzo_unitario
FROM vendite
ORDER BY prezzo_unitario DESC
LIMIT 5;

/* - I 3 prodotti meno venduti per quantità totale: mostra i nomi dei 3 prodotti con la quantità totale più bassa venduta (usa SUM e LIMIT) */
SELECT prodotto, SUM(quantita) AS Quantita_Totale
FROM vendite
GROUP BY prodotto
ORDER BY Quantita_Totale ASC
LIMIT 3;
