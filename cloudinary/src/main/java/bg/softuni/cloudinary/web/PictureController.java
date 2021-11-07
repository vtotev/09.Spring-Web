package bg.softuni.cloudinary.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PictureController {

    @GetMapping("/pictures/add")
    public String addPicture() {
        return "add";
    }
}
