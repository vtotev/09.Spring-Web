package bg.softuni.errorhandling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrdersController {
    @GetMapping("/orders/{id}/details")
    public String showOtfrtDetails(@PathVariable("id") Long productId) {
        throw new ObjectNotFoundException(productId);

    }
}
