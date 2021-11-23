package softuni.photostore.service.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.photostore.model.entity.accounts.User;
import softuni.photostore.model.entity.accounts.UserRole;
import softuni.photostore.model.entity.enums.UserRoleEnum;
import softuni.photostore.model.service.UserRegistrationServiceModel;
import softuni.photostore.repository.UserRoleRepository;
import softuni.photostore.repository.UsersRepository;
import softuni.photostore.service.UsersService;

import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRoleRepository userRoleRepository;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppUserServiceImpl appUserService;

    public UsersServiceImpl(UserRoleRepository userRoleRepository, UsersRepository usersRepository, PasswordEncoder passwordEncoder, AppUserServiceImpl appUserService) {
        this.userRoleRepository = userRoleRepository;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.appUserService = appUserService;
    }

    @Override
    public void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(UserRoleEnum.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public boolean isUserNameFree(String userName) {
        return usersRepository.findByUsernameIgnoreCase(userName).isEmpty();
    }

    @Override
    public boolean isEmailFree(String email) {
        return usersRepository.findByEmailIgnoreCase(email).isEmpty();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegSvcModel) {
        UserRole userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        User newUser = new User();

        newUser
                .setUsername(userRegSvcModel.getUsername())
                .setFirstName(userRegSvcModel.getFirstName())
                .setLastName(userRegSvcModel.getLastName())
                .setActive(true)
                .setPassword(passwordEncoder.encode(userRegSvcModel.getPassword()))
                .setEmail(userRegSvcModel.getEmail())
                .setRoles(Set.of(userRole));

        newUser = usersRepository.save(newUser);

        // this is the Spring representation of a user
        UserDetails principal = appUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);
    }
}
