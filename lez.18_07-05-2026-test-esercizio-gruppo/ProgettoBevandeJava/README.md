# ProgettoBevandeJava_DTA

# ☕ Sistema di Personalizzazione Bevande - Java

## TESTO DELL'ESERCIZIO:
ESERCIZIO – SISTEMA DI PERSONALIZZAZIONE BEVANDE CON DECORATOR E SINGLETON SCRIVI UN PROGRAMMA IN JAVA CHE SIMULI UN SISTEMA DI ORDINAZIONE PER UN BAR O UNA CAFFETTERIA. IL SISTEMA DEVE PERMETTERE DI CREARE UNA BEVANDA BASE E DI AGGIUNGERE INGREDIENTI EXTRA, MODIFICANDO
DINAMICAMENTE DESCRIZIONE E COSTO FINALE.

IL PROGRAMMA DEVE UTILIZZARE:
 - PATTERN DECORATOR
 - PATTERN SINGLETON

COME ESTENSIONE FACOLTATIVA, PUOI AGGIUNGERE ANCHE IL SALVATAGGIO DEGLI ORDINI SU DATABASE.

TRACCIA GENERALE

OGNI ORDINE PARTE DA UNA BEVANDA BASE, AD ESEMPIO:
 - CAFFÈ
 - TÈ
 - CIOCCOLATA CALDA

A QUESTA BEVANDA L’UTENTE PUÒ AGGIUNGERE UNO O PIÙ EXTRA, AD ESEMPIO:
 - LATTE
 - ZUCCHERO
 - CACAO
 - PANNA
 - CANNELLA
OGNI EXTRA DEVE AUMENTARE IL COSTO TOTALE E MODIFICARE LA DESCRIZIONE FINALE DELLA BEVANDA.

PARTE 1 – DECORATOR
CREA UNA STRUTTURA CHE PERMETTA DI AGGIUNGERE INGREDIENTI IN MODO DINAMICO A UNA BEVANDA.
COMPONENTE BASE

DEFINISCI UNA CLASSE ASTRATTA O UN’INTERFACCIA CHIAMATA AD ESEMPIO BEVANDA, CON ALMENO I METODI:
 - GETDESCRIZIONE()
 - GETCOSTO()

COMPONENTI CONCRETI - CREA ALCUNE BEVANDE BASE CONCRETE, AD ESEMPIO:
 - CAFFE
 - TE
 - CIOCCOLATA
OGNUNA DEVE AVERE:
 - UNA DESCRIZIONE INIZIALE
 - UN COSTO BASE

DECORATORE ASTRATTO
CREA UNA CLASSE ASTRATTA INGREDIENTEDECORATOR CHE IMPLEMENTA O ESTENDE BEVANDA E CHE CONTENGA UN RIFERIMENTO A UNA BEVANDA DA DECORARE.


DECORATORI CONCRETI
CREA ALMENO QUATTRO DECORATORI CONCRETI, AD ESEMPIO:
 - LATTE
 - ZUCCHERO
 -PANNA
 - CANNELLA
OGNI DECORATORE DEVE:
 - AGGIUNGERE TESTO ALLA DESCRIZIONE
 - AUMENTARE IL COSTO FINALE

L’UTENTE DEVE POTER AGGIUNGERE PIÙ DECORATORI ALLA STESSA BEVANDA.

PARTE 2 – SINGLETON
CREA UNA CLASSE GESTOREORDINI CHE RISPETTI IL PATTERN SINGLETON.

QUESTA CLASSE DEVE:
 - AVERE UNA SOLA ISTANZA IN TUTTO IL PROGRAMMA
 - GESTIRE GLI ORDINI EFFETTUATI
 - MEMORIZZARE IL RIEPILOGO DELL’ORDINE CORRENTE OPPURE LO STORICO DEGLI ORDINI
 - FORNIRE METODI PER AGGIUNGERE, VISUALIZZARE E CONFERMARE ORDINI
 - IL COSTRUTTORE DEVE ESSERE PRIVATO E L’ACCESSO ALL’ISTANZA DEVE AVVENIRE TRAMITE UN METODO PUBBLICO.

FUNZIONALITÀ RICHIESTE
IL PROGRAMMA DEVE PRESENTARE UN MENU SIMILE A QUESTO:
1 - CREA NUOVA BEVANDA
2 - AGGIUNGI INGREDIENTE EXTRA
3 - VISUALIZZA BEVANDA CORRENTE
4 - CONFERMA ORDINE
5 - VISUALIZZA STORICO ORDINI
6 - ESCI
OGNI TEAM DEVE PROPPORE UN EXTRA ENTRO IL 3 CHECK.


---
# 📌 Descrizione del progetto
Questo progetto simula un sistema di ordinazione bevande (distributore).
L’utente può selezionare una bevanda base e arricchirla con ingredienti extra dinamici (decorazioni), fino a ottenere un ordine finale con costo e descrizione personalizzati 

Il sistema è strutturato seguendo diversi **Design Pattern** per garantire modularità, estendibilità e separazione delle responsabilità.

---

# 🧠 Design Pattern utilizzati

## 1. 🧩 Decorator Pattern

### 📍 Scopo
Permette di aggiungere dinamicamente ingredienti extra a una bevanda senza modificare le classi base.

### 📦 Struttura

- `Bevanda` → Interfaccia base
- `Caffe`, `Te`, `CioccolataCalda` → Componenti concreti
- `DecoratorBevanda` → classe astratta decoratore
- Decoratori concreti:
  - `DecoratorLatte`
  - `DecoratorZucchero`
  - `DecoratorCacao`
  - `DecoratorPanna`
  - `DecoratorCannella`

### ⚙️ Funzionamento

Ogni decoratore:
- Riceve una `Bevanda`
- Modifica:
  - `getDescrizione()`
  - `getCosto()`

Esempio:
Bevanda bevanda = new Caffe();
bevanda = new DecoratorLatte(bevanda);
bevanda = new DecoratorZucchero(bevanda);

➡️ Risultato: bevanda con descrizione e prezzo modificati dinamicamente.

---

## 2. 🧵 Singleton Pattern

### 📍 Scopo
Garantire una sola istanza per la gestione degli ordini.

### 📦 Classe coinvolta
- `S_GestoriOrdini`

### ⚙️ Funzionamento

- Costruttore privato
- Istanza statica unica
- Accesso tramite:
S_GestoriOrdini.getIstanza();

### 📌 Responsabilità
- Salvare storico ordini
- Confermare ordini
- Visualizzare storico

---

## 3. 🎯 Strategy Pattern

### 📍 Scopo
Applicare dinamicamente diversi tipi di sconto.

### 📦 Struttura

- `StrategySconti` → interfaccia
- `StrategyNormali` → nessuno sconto
- `StrategyStudente` → sconto 20%

### ⚙️ Funzionamento

macchinetta.setStrategy(new StrategyStudente());

➡️ Il prezzo finale viene calcolato dinamicamente.

---

## 4. 🏛 Facade Pattern

### 📍 Scopo
Fornire un’interfaccia semplificata per gestire la logica del bar.

### 📦 Classe
- `BarFacade`

### ⚙️ Responsabilità

- Creazione bevande base
- Interazione con Singleton
- Gestione archiviazione ordini

---

# 🧱 Architettura generale (MVC + Pattern)

## 📁 Controller
MacchinettaController
- Gestisce input utente
- Coordina View e Model
- Applica Strategy
- Usa Facade per logica business

---

## 📁 Model

- Bevande base: Caffe, Te, CioccolataCalda
- Decorator: ingredienti extra
- Singleton: S_GestoriOrdini
- Facade: BarFacade

---

## 📁 View

MacchinettaView
- Menu
- Stampe
- Storico ordini
- Bevanda corrente

---

## 📁 Main

EsercizioMacchinetta
- Loop principale
- Input utente
- Collegamento controller

---

# 🔄 Flusso del programma

1. Creazione bevanda base
2. Aggiunta ingredienti (Decorator)
3. Visualizzazione bevanda
4. Conferma ordine
5. Applicazione Strategy (sconti)
6. Salvataggio nel Singleton
7. Visualizzazione storico

---

# 🚀 Punti di forza

- Uso di più Design Pattern
- Struttura MVC chiara
- Codice estendibile
- Separazione responsabilità

---
