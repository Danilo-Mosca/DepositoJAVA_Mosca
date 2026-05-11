-- Esercizio 1 – INNER JOIN + WHERE + LIKE
-- Visualizzare l’elenco dei libri venduti in almeno un negozio, mostrando:
-- titolo del libro, autore, data_vendita, negozio.
-- Includere solo i libri il cui autore contiene la stringa “King” (indipendentemente da maiuscole/minuscole).

SELECT libri.titolo, libri.autore, vendite.data_vendita, vendite.negozio
FROM libri INNER JOIN vendite ON libri.id = vendite.id_libro
WHERE UPPER(libri.autore) LIKE "%King%";
-- ma andava bene anche così: WHERE libri.autore LIKE "%King%";