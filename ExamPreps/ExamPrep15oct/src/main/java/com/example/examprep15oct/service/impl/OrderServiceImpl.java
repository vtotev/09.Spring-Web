package com.example.examprep15oct.service.impl;

import com.example.examprep15oct.model.entity.Order;
import com.example.examprep15oct.model.service.OrderServiceModel;
import com.example.examprep15oct.model.view.OrderViewModel;
import com.example.examprep15oct.repository.OrderRepository;
import com.example.examprep15oct.security.CurrentUser;
import com.example.examprep15oct.service.CategoryService;
import com.example.examprep15oct.service.OrderService;
import com.example.examprep15oct.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));
        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrdersOrderByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
