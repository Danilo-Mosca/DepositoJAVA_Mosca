## 4. Esercizio — Gestione Prodotti con DI. Esercizio n.1 del 13/05/2026

### Obiettivo

Creare un mini-sistema di gestione prodotti che mette insieme tutti i concetti imparati:
- `PrezzoService` — calcola il prezzo scontato
- `ProdottoService` — gestisce la lista prodotti, usa `PrezzoService` via DI
- `@PostConstruct` — inizializza i dati alla partenza
- `CommandLineRunner` — stampa i risultati in console

---

### Struttura del progetto

```
src/main/java/com/esempio/demo/
├── DemoApplication.java
└── service/
    ├── PrezzoService.java
    └── ProdottoService.java
```

---

### Traccia

**Step 1 — Crea `PrezzoService`**

Crea un `@Service` con un metodo `calcolaPrezzioScontato(double prezzoOriginale, int percentualeSconto)` che restituisce il prezzo dopo lo sconto.

**Step 2 — Crea `ProdottoService`**

Crea un `@Service` che:
- Ha una `List<String>` per i nomi prodotti e una `Map<String, Double>` per i prezzi
- Inietta `PrezzoService` via costruttore
- Usa `@PostConstruct` per popolare la lista con almeno 3 prodotti e i loro prezzi
- Ha un metodo `stampaCatalogo(int percentualeSconto)` che stampa ogni prodotto con il prezzo scontato

**Step 3 — Avvia da `CommandLineRunner`**

In `DemoApplication`, usa un `CommandLineRunner` per chiamare `stampaCatalogo(20)` (sconto del 20%).

---

**Output atteso:**

```
[ProdottoService] Catalogo inizializzato con 4 prodotti.

========================================
  CATALOGO PRODOTTI — Sconto: 20%
========================================
  Laptop Pro 15"            1299.99€  →  1039.99€
  Mouse Wireless              49.90€  →    39.92€
  Tastiera Meccanica         129.50€  →   103.60€
  Monitor 4K 27"             549.00€  →   439.20€
========================================
```

---