package com.example.libreria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libreria.model.Book;
import com.example.libreria.model.Genre;
import com.example.libreria.record.BookRequest;
import com.example.libreria.record.BookResponse;
import com.example.libreria.service.BookService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService; // dichiaro una variabile di tipo private final di BookService

    // Constructor Injection
    // costruttore e injection di bookService (iniettiamo la service bookService
    // dentro il controller così questo sarà in grado di chiamare la service (che a
    // sua volta chiamerà la repository per eseguire le query)
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET /api/books → lista di tutte i libri
    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        List<BookResponse> books = bookService.findAll();
        
        return ResponseEntity.ok(books);
    }

    // Metodo che recupera il singolo libro per id
    // GET /api/books/{id} → singolo libro per ID
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Integer id) {
        BookResponse book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    // Metodo che recupera i libri per titolo
    @GetMapping("/titolo/{title}")
    public ResponseEntity<BookResponse> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.getBookByTitle(title));
    }

    // Metodo che recupera i libri per genere
    @GetMapping("/genere/{genre}")
    public ResponseEntity<List<BookResponse>> getBooksByGenre(@PathVariable Genre genre) {
        List<BookResponse> books = bookService.getBooksByGenre(genre);
        
        return ResponseEntity.ok(books);
    }

    // Metodo che recupera i libri per autore
    @GetMapping("/autore/{author}")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@PathVariable String author) {
        List<BookResponse> book = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(book);
        //Oppure
        // return ResponseEntity.ok(bookService.getBooksByAuthor(author));

    }

    // POST /api/books → crea un nuovo libro
    // BindingResult permette di catturare gli errori di validazione nel metodo del
    // Controller e gestirli manualmente, invece di lasciare che Spring li gestisca
    // automaticamente.
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BookRequest newBook, BindingResult bindingResult) {
        //Di seguito il codice senza usare il BindingResult
        //Book book = bookService.create(newBook);
        // Restituisce 201 Created con il prodotto appena creato
        //return ResponseEntity.status(201).body(book);

        //Di seguito il codice con la classe BindingResult per una gestione strutturata degli errori

        // Controllo errori validazione
        // CONTROLLO PRIMA DI TUTTO SE CI SONO DEGLI ERRORI DI VALIDAZIONE
        if (bindingResult.hasErrors()) {
            //Mi creo una Collection di tipo Map che associa una chiave ad un valore, in questo caso String = chiave e la seconda String = valore
            Map<String, String> errors = new HashMap<>();
            //Ciclo con un forEach ed il metodo getFieldErrors() di bindingResult alla ricerca degli errori e se questi sono presenti li aggiungo alla Map errors
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            //Allora ritorno uno http status code error 400 bad request e nel body la map contenente tutti gli errori rilevati da BindingResult
            return ResponseEntity.badRequest().body(errors);
        }
        //Se la classe non ha intercettato errori allora ritorno un http status code 201 created e richiamo il metodo del BookService per salvare il libro
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(newBook));
    }

    // PUT /api/books/{id} → aggiorna un libro esistente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody BookRequest bookDetails, BindingResult bindingResult) {
        // Di seguito il codice senza usare il BindingResult
        //Optional<Book> book = bookService.update(id, bookDetails);
        //return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

        // Di seguito il codice con la classe BindingResult per una gestione strutturata
        // degli errori

        // Controllo errori validazione
        // CONTROLLO PRIMA DI TUTTO SE LA CLASSE HA INTERCETTATO DEGLI ERRORI DI VALIDAZIONE
        if (bindingResult.hasErrors()) {
            // Mi creo una Collection di tipo Map che associa una chiave ad un valore, in
            // questo caso String = chiave e la seconda String = valore
            Map<String, String> errors = new HashMap<>();
            // Ciclo con un forEach ed il metodo getFieldErrors() di bindingResult alla
            // ricerca degli errori e se questi sono presenti li aggiungo alla Map errors
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

            // Allora ritorno uno http status code error 400 bad request e nel body la map
            // contenente tutti gli errori rilevati da BindingResult
            return ResponseEntity.badRequest().body(errors);
        }
        // Se la classe non ha intercettato errori allora ritorno un http status code
        // 200 ok e richiamo il metodo del BookService per salvare il libro
        return ResponseEntity.status(HttpStatus.OK).body(bookService.update(id, bookDetails));
    }

    // DELETE /api/books/{id} → elimina un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/runs/search?author=nomeAutore&title=nomeTitolo -> ricerca per query
    // string
    @GetMapping("/search")
    public ResponseEntity<BookResponse> search(@RequestParam String author, @RequestParam String title) {
        return ResponseEntity.ok(bookService.search(author, title));
    }
}