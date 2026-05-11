-- Esercizio 4 – RIGHT JOIN + WHERE + LIKE + BETWEEN
-- Mostrare tutti i record di vendita, anche quelli che fanno riferimento a libri non più presenti nella tabella Libri (caso anomalo).
-- Mostrare: titolo (se esiste), data_vendita, prezzo, quantita.
-- Includere solo le vendite:
-- avvenute tra il 2020-01-01 e il 2022-12-31
-- presso negozi il cui nome contiene la parola “Drive” (case-insensitive).

SELECT libri.titolo, vendite.data_vendita, libri.prezzo, vendite.quantita
FROM libri RIGHT JOIN vendite ON libri.id = vendite.id_libro
WHERE vendite.data_vendita BETWEEN "2020-01-01" AND "2022-12-31" AND LOWER(vendite.negozio) LIKE "%Drive%";
-- oppure equivalente: WHERE vendite.data_vendita BETWEEN "2020-01-01" AND "2022-12-31" AND vendite.negozio LIKE "%Drive%";