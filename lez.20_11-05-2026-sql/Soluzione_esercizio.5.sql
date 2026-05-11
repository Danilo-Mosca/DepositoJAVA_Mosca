-- Esercizio 5 – INNER JOIN + WHERE combinato
-- Mostrare titolo, autore, prezzo e data_vendita dei libri:
-- con genere IN (‘Fantasy’, ‘Horror’, ‘Drama’) (ignora i libri con >1 genere)
-- pubblicati dopo il 2015,
-- venduti in negozi il cui nome contiene ‘Plaza’,
-- ordinati dal più recente al più vecchio.

SELECT libri.titolo, libri.autore, libri.prezzo, vendite.data_vendita
FROM libri INNER JOIN vendite ON libri.id = vendite.id_libro
WHERE libri.genere IN ('Fantasy','Horror','Drama')
-- oppure: WHERE libri.genere = "Fantasy" OR libri.genere = "Horror" OR libri.genere = "Drama"
	AND libri.anno_pubblicazione > 2015 
    AND vendite.negozio LIKE "%Plaza"
ORDER BY libri.anno_pubblicazione DESC;