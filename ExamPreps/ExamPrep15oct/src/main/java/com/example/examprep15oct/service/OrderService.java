package com.example.examprep15oct.service;

import com.example.examprep15oct.model.service.OrderServiceModel;
import com.example.examprep15oct.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderByPriceDesc();

    void readyOrder(Long id);
}
