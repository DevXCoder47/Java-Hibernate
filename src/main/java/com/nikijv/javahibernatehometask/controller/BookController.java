package com.nikijv.javahibernatehometask.controller;
import com.nikijv.javahibernatehometask.model.Book;
import com.nikijv.javahibernatehometask.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/create/book")
    public String createBook(@RequestBody Book book) {
        bookService.save(book);
        return "Book saved!";
    }

    @PutMapping("update/book/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return "Book updated!";
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("book/id/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("book/title/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("book/author/{author}")
    public Book getBookByAuthor(@PathVariable String author) {
        return bookService.getBookByAuthor(author);
    }

    @GetMapping("book/year/{year}")
    public Book getBookByYear(@PathVariable String year) {
        return bookService.getBookByYear(year);
    }

    @GetMapping("book/genre/{genre}")
    public Book getBookByGenre(@PathVariable String genre) {
        return bookService.getBookByGenre(genre);
    }

    @GetMapping("book/pages/{pages}")
    public Book getBookByPages(@PathVariable int pages) {
        return bookService.getBookByPages(pages);
    }

    @GetMapping("book/description-word/{descriptionWord}")
    public Book getBookByDescriptionWord(@PathVariable String descriptionWord) {
        return bookService.getBookByDescriptionWord(descriptionWord);
    }

    @DeleteMapping("delete/book/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted!";
    }
}
//http://localhost:8080/swagger-ui/index.html
