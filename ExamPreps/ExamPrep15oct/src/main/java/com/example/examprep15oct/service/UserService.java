package com.example.examprep15oct.service;

import com.example.examprep15oct.model.entity.User;
import com.example.examprep15oct.model.service.UserServiceModel;
import com.example.examprep15oct.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
    User findById(Long id);

    void login(Long id, String username);
    void logout();

    List<UserViewModel> findAllUsersAndCountOfOrdersOrderByCountDesc();
}
