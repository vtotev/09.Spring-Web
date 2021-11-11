package bg.softuni.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @GetMapping("/products/{id}/details")
    public String showProductDetails(@PathVariable("id") Long productId) {
        throw new ProductNotFoundException(productId);

    }

    @GetMapping("/products/{id}/error")
    public String boom(@PathVariable("id") String productId) {
        throw new NullPointerException();

    }

}
