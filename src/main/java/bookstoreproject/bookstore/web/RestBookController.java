package bookstoreproject.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bookstoreproject.bookstore.domain.Book;
import bookstoreproject.bookstore.domain.BookRepository;

@RestController
public class RestBookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getbooks")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/getbook/{id}")
    public Optional<Book> getOneBook(@PathVariable("id") Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/addbook")
    public Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @PutMapping("/editbook/{id}")
    public Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }

    @DeleteMapping("deletebook/{id}")
    public Iterable<Book> deleteBook(@RequestBody Book deletedBook, @PathVariable Long id) {
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }
}
