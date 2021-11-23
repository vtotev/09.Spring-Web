package softuni.photostore.service;

import softuni.photostore.model.service.UserRegistrationServiceModel;

public interface UsersService {
    void initializeRoles();

    boolean isUserNameFree(String userName);

    boolean isEmailFree(String email);

    void registerAndLoginUser(UserRegistrationServiceModel userRegSvcModel);
}
