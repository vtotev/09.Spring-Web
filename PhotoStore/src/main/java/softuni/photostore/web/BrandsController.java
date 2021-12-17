package softuni.photostore.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import softuni.photostore.service.CameraService;

@ControllerAdvice
public class BrandsController {

    private final CameraService cameraService;

    public BrandsController(CameraService cameraService) {
        this.cameraService = cameraService;
    }


    @ModelAttribute
    public void getBrands(Model model) {
        model.addAttribute("cameraBrands", cameraService.getAllBrands());
    }
}
