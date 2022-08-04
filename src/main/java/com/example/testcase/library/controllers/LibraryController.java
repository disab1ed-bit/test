package com.example.testcase.library.controllers;

import com.example.testcase.library.exceptions.AuthorNotFound;
import com.example.testcase.library.exceptions.BookNotFound;
import com.example.testcase.library.model.Author;
import com.example.testcase.library.model.AuthorDTO;
import com.example.testcase.library.model.Book;
import com.example.testcase.library.model.BookDTO;
import com.example.testcase.library.repositories.AuthorRepository;
import com.example.testcase.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTMLDocument;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LibraryController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @GetMapping("/login")
    public ResponseEntity<HTMLDocument> login() {
        return ResponseEntity.ok(new HTMLDocument());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable("id") Long id) {
        final Book book = bookRepository.findById(id)
                .orElseThrow(BookNotFound::new);

        return ResponseEntity.ok(BookDTO.of(book));
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> findBooks() {
        final List<BookDTO> books = bookRepository.findAll()
                .stream()
                .map(BookDTO::of)
                .collect(Collectors.toList());

        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }

    @GetMapping("/findbooks")
    public ResponseEntity<List<BookDTO>> findBooksByQuery(@RequestParam String query) {
        final List<BookDTO> books = bookRepository.findBooks(query)
                .stream()
                .map(BookDTO::of)
                .collect(Collectors.toList());

        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDTO> findAuthorById(@PathVariable("id") Long id) {
        final Author author = authorRepository.findById(id)
                .orElseThrow(AuthorNotFound::new);

        return ResponseEntity.ok(AuthorDTO.of(author));
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDTO>> findAuthors() {
        final List<AuthorDTO> authors = authorRepository.findAll()
                .stream()
                .map(AuthorDTO::of)
                .collect(Collectors.toList());

        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(authors);
        }
    }

    @GetMapping("/about")
    public ResponseEntity<String> about() {
        return ResponseEntity.ok("");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("");
    }

}
