package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDto;

import java.util.List;

public interface BooksService {

    List<BookDto> getAllBooks();

}
