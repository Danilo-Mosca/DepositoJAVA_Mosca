-- Esercizio 2 – LEFT JOIN + WHERE + BETWEEN
-- Visualizzare tutti i libri, anche quelli che non hanno ancora vendite registrate, mostrando per ciascuno:
-- titolo, anno_pubblicazione, prezzo, data_vendita (se presente).
-- Filtrare i risultati per anno_pubblicazione compreso tra 2000 e 2010

SELECT libri.id, libri.anno_pubblicazione, libri.prezzo, vendite.data_vendita
FROM libri LEFT JOIN vendite ON libri.id = vendite.id_libro
WHERE libri.anno_pubblicazione BETWEEN 2000 AND 2010;