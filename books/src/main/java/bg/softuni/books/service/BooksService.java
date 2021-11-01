package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    List<BookDto> getAllBooks();
    Optional<BookDto> getBookById(Long id);
    void deleteBook(Long id);
    long createBook(BookDto bookDto);
}
