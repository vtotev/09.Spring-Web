package bg.softuni.books.service.impl;

import bg.softuni.books.model.dto.AuthorDto;
import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.repository.BooksRepository;
import bg.softuni.books.service.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final ModelMapper modelMapper;

    public BooksServiceImpl(BooksRepository booksRepository, ModelMapper modelMapper) {
        this.booksRepository = booksRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return booksRepository.findAll().stream().map(b -> {
            BookDto bookDto = modelMapper.map(b, BookDto.class);
            AuthorDto authorDto = modelMapper.map(b.getAuthor(), AuthorDto.class);
            bookDto.setAuthor(authorDto);
            return bookDto;
        }).collect(Collectors.toList());
    }
}
