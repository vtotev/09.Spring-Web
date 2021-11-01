package bg.softuni.books.service.impl;

import bg.softuni.books.model.dto.AuthorDto;
import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BooksRepository;
import bg.softuni.books.service.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;

    public BooksServiceImpl(BooksRepository booksRepository, ModelMapper modelMapper, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.modelMapper = modelMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return booksRepository.findAll().stream().map(this::asBook).collect(Collectors.toList());
    }

    private BookDto asBook(BookEntity b) {
        BookDto bookDto = modelMapper.map(b, BookDto.class);
        AuthorDto authorDto = modelMapper.map(b.getAuthor(), AuthorDto.class);
        bookDto.setAuthor(authorDto);
        return bookDto;
    }

    @Override
    public Optional<BookDto> getBookById(Long id) {
        return booksRepository.findById(id).map(this::asBook);
    }

    @Override
    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }

    @Override
    public long createBook(BookDto bookDto) {
        AuthorEntity author = authorRepository
                .findByName(bookDto.getAuthor().getName())
                .orElseGet(() -> new AuthorEntity().setName(bookDto.getAuthor().getName()));
        this.authorRepository.save(author);
        BookEntity newBook = new BookEntity();
        newBook.setAuthor(author)
                .setIsbn(bookDto.getIsbn())
                .setTitle(bookDto.getTitle());
        return booksRepository.save(newBook).getId();
    }
}
