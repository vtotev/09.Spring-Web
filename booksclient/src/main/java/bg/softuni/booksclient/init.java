package bg.softuni.booksclient;

import bg.softuni.booksclient.model.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class init implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(init.class);
    private final RestTemplate restTemplate;

    public init(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<BookDto[]> booksResponse = restTemplate.getForEntity("http://localhost:8080/books", BookDto[].class);
        if (booksResponse.hasBody()) {
            BookDto[] books = booksResponse.getBody();
            for (BookDto book : books) {
                LOGGER.info("A book that came from the server: {}", book.toString());
            }
        }
    }

}
