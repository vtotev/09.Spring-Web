package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.models.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.models.service.UserServiceModel;
import bg.softuni.pathfinder.models.view.UserViewModel;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.utils.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login (Model model) {
        if (!model.containsAttribute("isExists")) {
            model.addAttribute("isExists", true);
        }
        return "login";
    }


    @GetMapping("/register")
    public String register (Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm (@Valid  UserRegisterBindingModel userRegisterBindingModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        boolean existing = userService.isNameExists(userRegisterBindingModel.getUsername());
        if (existing) {
            // TODO
            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("isExists", false)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";

        }
        userService.loginUser(user.getId(), user.getUsername());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();;
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model) {

        model.addAttribute("user", modelMapper.map(userService.findById(id), UserViewModel.class));

        return "profile";
    }

}
