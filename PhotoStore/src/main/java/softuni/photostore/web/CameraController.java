package softuni.photostore.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.photostore.model.binding.CameraAddBindingModel;
import softuni.photostore.model.binding.CameraBrandAddBindingModel;
import softuni.photostore.model.entity.cameras.CameraModel;
import softuni.photostore.model.entity.enums.CameraTypeEnum;
import softuni.photostore.model.service.CameraFilterModel;
import softuni.photostore.service.CameraBrandsService;
import softuni.photostore.service.CameraService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CameraController {
    private final CameraService cameraService;
    private final CameraBrandsService brandsService;
    private final ModelMapper modelMapper;

    public CameraController(CameraService cameraService, CameraBrandsService brandsService, ModelMapper modelMapper) {
        this.cameraService = cameraService;
        this.brandsService = brandsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/cameras/{type}")
    public String getCamerasByBrand(@PathVariable String type, Model model) {
        List<CameraModel> allCamerasByType = cameraService.getAllCamerasByType(type);
        model.addAttribute("cameras", allCamerasByType);
        model.addAttribute("camType", CameraTypeEnum.valueOf(type.toUpperCase()).getTitle());
        if (!model.containsAttribute("filter")) {
            model.addAttribute("filter", new CameraFilterModel()
                    .setBrand("")
                    .setSensorSize(""));
        }
        if (!model.containsAttribute("areCamerasAvailable")) {
            model.addAttribute("areCamerasAvailable", !allCamerasByType.isEmpty());
        }
        return "cameras";
    }

    @PostMapping("/cameras/{type}")
    public String filterCameras(@PathVariable String type, CameraFilterModel filterModel, Model model) {
        List<CameraModel> allCamerasByFilterCriteria = cameraService.getAllCamerasByFilterCriteria(filterModel, type);
        model.addAttribute("cameras", allCamerasByFilterCriteria);
        model.addAttribute("camType", CameraTypeEnum.valueOf(type.toUpperCase()).getTitle());
        model.addAttribute("filter", filterModel);
        model.addAttribute("areCamerasAvailable", !allCamerasByFilterCriteria.isEmpty());
        return "cameras";
    }


    // CAMERA BRANDS OPERATIONS

    @GetMapping("/cameras/manage")
    public String manage(Model model) {
        model.addAttribute("brands", brandsService.getAllBrands());
        model.addAttribute("cameras", cameraService.getAllCameras());
        if (!model.containsAttribute("newBrand")) {
            model.addAttribute("newBrand", new CameraBrandAddBindingModel())
                    .addAttribute("brandExisting", false);
        }
        if (!model.containsAttribute("brandNotMeetingRequirements")) {
            model.addAttribute("brandNotMeetingRequirements", false);
        }
        if (!model.containsAttribute("brandAddedSuccessfully")) {
            model.addAttribute("brandAddedSuccessfully", false);
        }
        return "cameras-manage";
    }

    @PostMapping("/cameras/manage/brand/add")
    public String addBrand(@Valid CameraBrandAddBindingModel brand, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        boolean brandExisting = brandsService.isBrandExisting(brand.getBrandName());

        if (brandExisting) {
            redirectAttributes.addFlashAttribute("brandExisting", brandExisting);
            return "redirect:/cameras/manage";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandNotMeetingRequirements", true);
            return "redirect:/cameras/manage";
        }
        boolean isRegistered = brandsService.registerNewBrand(brand);
        redirectAttributes.addFlashAttribute("brandAddedSuccessfully", isRegistered);
        return "redirect:/cameras/manage";
    }

    @PostMapping("cameras/manage/brand/delete/{id}")
    public String deleteBrand(@PathVariable String id) {
        brandsService.deleteBrandWithId(id);
        return "redirect:/cameras/manage";
    }


    // CAMERA MODELS OPERATIONS

    @GetMapping("/cameras/manage/model/add")
    public String addCamera(Model model) {
        model.addAttribute("brands", brandsService.getAllBrands());
        if (!model.containsAttribute("noPictureSelected")) {
            model.addAttribute("noPictureSelected", false);
        }
        if (!model.containsAttribute("cameraModel")) {
            model.addAttribute("cameraModel", new CameraAddBindingModel());
        }
        return "camera-add";
    }

    @PostMapping("/cameras/manage/model/add")
    public String addCameraConfirm(@Valid CameraAddBindingModel cameraAddBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || cameraAddBindingModel.getPicture().isEmpty()) {
            redirectAttributes.addFlashAttribute("cameraModel", cameraAddBindingModel);
            if (cameraAddBindingModel.getPicture().isEmpty()) {
                redirectAttributes.addFlashAttribute("noPictureSelected", true);
            }
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cameraModel", bindingResult);
            return "redirect:/cameras/manage/model/add";
        }

        boolean result = cameraService.addNewCamera(cameraAddBindingModel);

        return "redirect:/cameras/manage";
    }

    @PostMapping("/cameras/manage/model/delete/{id}")
    public String deleteCameraModel(@PathVariable String id) {
        cameraService.deleteModelById(id);
        return "redirect:/cameras/manage";
    }

    @GetMapping("/cameras/manage/edit/{id}")
    public String editCamera(@PathVariable String id, Model model) {
        model.addAttribute("brands", brandsService.getAllBrands());
        if (!model.containsAttribute("cameraModel")) {
            CameraModel cameraById = cameraService.getCameraById(id);
            CameraAddBindingModel editModel = modelMapper.map(cameraById, CameraAddBindingModel.class);
            editModel.setBrand(cameraById.getBrand().getBrandName());
            model.addAttribute("cameraModel", cameraService.getCameraById(id));
        }
        return "camera-edit";
    }

    @PostMapping("/cameras/manage/edit/{id}")
    public String editCameraConfirm(@PathVariable String id,
                                    @Valid CameraAddBindingModel cameraAddBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("cameraModel", cameraAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cameraModel", bindingResult);
            return "redirect:/cameras/manage/edit/"+id;
        }

        boolean result = cameraService.editCamera(id, cameraAddBindingModel);

        return "redirect:/cameras/manage";
    }

    // CAMERA DETAILS VIEW

    @GetMapping("/cameras/details/{id}")
    public String showCameraDetails(@PathVariable String id, Model model) {
        model.addAttribute("camera", cameraService.getCameraById(id));
        return "camera-details";
    }
}
