-- Esercizio 3 – INNER JOIN + WHERE + IN
-- Visualizzare i dati dei libri venduti nei negozi appartenenti a una lista specifica:
-- ("9 Oriole Lane", "98558 Milwaukee Point", "98016 Esch Trail").
-- Mostrare titolo, negozio, quantita, prezzo totale (quantita * prezzo).

SELECT libri.titolo, vendite.negozio, vendite.quantita, libri.prezzo * vendite.quantita AS Prezzo_totale
FROM libri INNER JOIN vendite ON libri.id = vendite.id_libro
WHERE vendite.negozio IN ("9 Oriole Lane", "98558 Milwaukee Point", "98016 Esch Trail");