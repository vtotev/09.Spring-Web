package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id) {
        Optional<BookDto> bookById = booksService.getBookById(id);
        if (bookById.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookById.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDto> deleteBookById(@PathVariable("id") Long id) {
        booksService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> create(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
        throw new UnsupportedOperationException("coming soon!");
    }

    @PostMapping()
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto, UriComponentsBuilder builder) {
        long bookId = booksService.createBook(bookDto);

        URI location = builder.path("/books/{id}").buildAndExpand(bookId).toUri();

        return ResponseEntity.created(location).build();
    }
}
