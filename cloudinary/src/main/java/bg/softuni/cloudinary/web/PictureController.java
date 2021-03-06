package bg.softuni.cloudinary.web;

import bg.softuni.cloudinary.model.binding.PictureBindingModel;
import bg.softuni.cloudinary.model.entity.PictureEntity;
import bg.softuni.cloudinary.model.view.PictureViewModel;
import bg.softuni.cloudinary.repository.PictureRepository;
import bg.softuni.cloudinary.service.CloudinaryImage;
import bg.softuni.cloudinary.service.CloudinaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PictureController {

    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;

    public PictureController(CloudinaryService cloudinaryService, PictureRepository pictureRepository) {
        // Do not use repos directly in controller
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/pictures/add")
    public String addPicture() {
        return "add";
    }

    @PostMapping("/pictures/add")
    public String addPicture(PictureBindingModel pictureBindingModel) throws IOException {
        var picture = createPictureEntity(pictureBindingModel.getPicture(), pictureBindingModel.getTitle());
        pictureRepository.save(picture);
        return "redirect:/pictures/all";
    }

    private PictureEntity createPictureEntity(MultipartFile file, String title) throws IOException {
        final CloudinaryImage uploaded = this.cloudinaryService.upload(file);
        return new PictureEntity().setPublicId(uploaded.getPublicId()).setTitle(title).setUrl(uploaded.getUrl());
    }

    @GetMapping("/pictures/all")
    public String all(Model model) {
        List<PictureViewModel> pictures = pictureRepository
                .findAll()
                .stream()
                .map(this::asViewModel).collect(Collectors.toList());

        model.addAttribute("pictures", pictures);
        return "all";
    }

    private PictureViewModel asViewModel(PictureEntity picture) {
        return new PictureViewModel().setPublicId(picture.getPublicId()).setTitle(picture.getTitle()).setUrl(picture.getUrl());
    }

    @Transactional
    @DeleteMapping("/pictures/delete")
    public String delete(@RequestParam("public_id") String publicId) {
        cloudinaryService.delete(publicId);
        pictureRepository.deleteAllByPublicId(publicId);
        return "redirect:all";
    }
}
