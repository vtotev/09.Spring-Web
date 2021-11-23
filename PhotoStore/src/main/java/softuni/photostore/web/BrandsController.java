package softuni.photostore.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import softuni.photostore.service.BrandsService;

@ControllerAdvice
public class BrandsController {

    private final BrandsService brandsService;

    public BrandsController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @ModelAttribute
    public void getBrands(Model model) {
        model.addAttribute("cameraBrands", brandsService.getAllBrands());
    }
}
