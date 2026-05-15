package com.example.libreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
import com.example.libreria.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    // Costruttore
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // GET /api/books → lista di tutte i libri
    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Metodo che recupera il singolo libro per id
    // GET /api/books/{id} → singolo libro per ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Metodo che recupera i libri per titolo
    @GetMapping("/titolo/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        Optional<Book> book = bookRepository.findByTitle(title);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Metodo che recupera i libri per genere
    @GetMapping("/genere/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable Genre genre) {
        List<Book> books = bookRepository.findByGenre(genre);

        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    // Metodo che recupera i libri per autore
    @GetMapping("/autore/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookRepository.findByAuthor(author);

        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    // POST /api/books → crea un nuovo libro
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book newBook) {
        Book saved = bookRepository.save(newBook);
        // Restituisce 201 Created con il prodotto appena creato
        return ResponseEntity.status(201).body(saved);
    }

    // PUT /api/books/{id} → aggiorna un libro esistente
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book bookDetails) {
        // Controllo l'esistenza di quella riga nel database
        Optional<Book> existing = bookRepository.findById(id);
        // se non trova il libro da agiornare, restituisce errore
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // Visto che existing non è vuoto prendo il body di della riga della Run da modificare e lo salvo in nella variabile run
        Book book = existing.get();
        // Setto i campi di run con i nuovi valori ricevuti dalla @RequestBody Run updateRun
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPages(bookDetails.getPages());
        book.setGenre(bookDetails.getGenre());
        // Salvo nel database
        Book update = bookRepository.save(book);
        return ResponseEntity.ok(update);
    }

    // DELETE /api/books/{id} → elimina un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/runs/search?author=nomeAutore&title=nomeTitolo -> ricerca per query string
    @GetMapping("/search")
    public ResponseEntity<Book> search(@RequestParam String author, @RequestParam String title ) {
        Optional<Book> book = bookRepository.findBookByAuthorAndTitle(author, title);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
