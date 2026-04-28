# 📚 Biblioteca Digitale - Progetto Java OOP

## 📌 Descrizione

Esercizio di Gruppo OOP – Gestione Biblioteca Digitale
Obiettivo:
    Realizzare in gruppo un progetto Java che rispetti tutte e tre le regole fondamentali dell’OOP:
        - Incapsulamento: tutti gli attributi devono essere privati e gestiti tramite getter/setter.
        - Ereditarietà: deve esserci almeno una classe derivata da una classe base.
        - Polimorfismo: deve essere usato, per esempio tramite overriding di metodi, gestione di collezioni miste, ecc.

Requisiti di progetto:
    - Il lavoro deve essere suddiviso tra i membri del gruppo (ogni membro un file/class principale o un’area di responsabilità).
    - Il progetto deve essere caricato su una repository separata e documentato (README.md con istruzioni, suddivisione compiti, etc.).
    - Puoi usare interfacce né classi astratte.

Traccia
Progetta un sistema per la gestione di una Biblioteca Digitale con queste caratteristiche:
1. Classe base: Risorsa
    - Attributi privati: titolo (String), annoPubblicazione (int), codice (String, identificativo univoco)
    - Metodi getter/setter per ogni attributo.
    - Metodo visualizzaDettagli() che stampa titolo, anno e codice.

2. Sottoclassi di Risorsa:
    - Libro (estende Risorsa):
        - Attributo privato: autore (String)
        - Override di visualizzaDettagli() che include l’autore.
    
    - Rivista (estende Risorsa):
        - Attributo privato: numero (int, numero della rivista)
        - Override di visualizzaDettagli() che include il numero della rivista.
    
    - Ebook (estende Risorsa):
        - Attributo privato: formato (String, es: PDF, EPUB)
        - Override di visualizzaDettagli() che include il formato.

3. Classe Utente:
    - Attributi privati: nome (String), idUtente (String)
    - Lista di risorse prese in prestito (ArrayList<Risorsa>)
    - Metodi per prendere in prestito/restutuire una risorsa e per stampare la lista delle risorse dell’utente.

4. Classe Biblioteca:
    - Attributi privati: nome biblioteca (String), lista risorse disponibili (ArrayList<Risorsa>), lista utenti (ArrayList<Utente>)
    - Metodi per aggiungere risorse/utenti, stampare l’inventario completo (usando il polimorfismo su visualizzaDettagli), cercare risorse per titolo.

5. Main:
    - Inserimento e stampa di più risorse di diversi tipi e almeno due utenti.
    - Dimostrazione di tutte e tre le regole (incapsulamento, ereditarietà, polimorfismo).

---

## 🧱 Struttura del Progetto

### 🔹 Classe Astratta: `Risorsa`
- Attributi:
  - `titolo`
  - `annoPubblicazione`
  - `codice`
- Metodi:
  - Getter
  - Metodo astratto `visualizzaDettagli()`

---

### 🔹 Sottoclassi di `Risorsa`

#### 📖 `Libro`
- Attributo: `autore`
- Override di `visualizzaDettagli()`

#### 📰 `Rivista`
- Attributo: `numeroRivista`
- Override di `visualizzaDettagli()`

#### 💻 `Ebook`
- Attributo: `formato`
- Override di `visualizzaDettagli()`

---

### 👤 Classe `Utente`
- Attributi:
  - `nome`
  - `idUtente`
  - Lista `prestiti`
- Funzionalità:
  - Prendere in prestito una risorsa
  - Restituire una risorsa
  - Visualizzare i prestiti

---

### 🏛️ Classe `Biblioteca`
- Attributi:
  - `nome`
  - Lista `risorse`
  - Lista `utenti`
- Funzionalità:
  - Aggiungere risorse e utenti
  - Stampare inventario (uso del polimorfismo)
  - Cercare risorse per titolo

---

### ▶️ `Main`
Gestisce l'interazione con l'utente tramite menu:

- Inserimento risorse
- Registrazione utenti
- Prestiti e restituzioni
- Visualizzazione dati

---

## 🧠 Principi OOP Applicati

### 🔒 Incapsulamento
Tutti gli attributi sono `private` e accessibili tramite getter/setter.

### 🧬 Ereditarietà
Le classi:
- `Libro`
- `Rivista`
- `Ebook`  
estendono la classe astratta `Risorsa`.

### 🔄 Polimorfismo
Utilizzo del metodo `visualizzaDettagli()` nelle collezioni di tipo `ArrayList<Risorsa>`.

---

## 👥 Suddivisione dei Compiti

| Componente | Sviluppatore |
|-----------|-------------|
| Classe `Risorsa` (astratta) | Danilo |
| Classi `Libro`, `Rivista`, `Ebook` | Mauro |
| Classe `Utente` | Danilo |
| Classe `Biblioteca` | Mauro |
| Classe `Main` | Danilo |

---

## ▶️ Come Eseguire il Progetto

1. Clonare la repository:
```bash
git clone <url-repository>
```


2. Compilare i file Java:
```bash
javac *.java
```

3. Avviare il programma:
```bash
java Main
```
---

## 📋 Requisiti

- Java JDK 8 o superiore
- Terminale o IDE (IntelliJ, Eclipse, VS Code)

---
