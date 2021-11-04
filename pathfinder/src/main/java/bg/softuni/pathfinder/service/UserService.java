package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.service.UserServiceModel;

import java.util.Optional;

public interface UserService {

     void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);
    void loginUser(Long id, String username);
    void logout();

    UserServiceModel findById(Long id);
    boolean isNameExists(String username);
}
