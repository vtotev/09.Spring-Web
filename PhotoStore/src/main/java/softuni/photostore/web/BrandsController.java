package softuni.photostore.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import softuni.photostore.service.CameraBrandsService;

@ControllerAdvice
public class BrandsController {

    private final CameraBrandsService brandsService;

    public BrandsController(CameraBrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @ModelAttribute
    public void getBrands(Model model) {
        model.addAttribute("cameraBrands", brandsService.getAllBrands());
    }
}
