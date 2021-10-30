package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> allBooks = booksService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

}
