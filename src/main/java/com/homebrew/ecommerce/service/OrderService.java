package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.OrderApi;

import java.util.List;

public interface OrderService {
    OrderApi getOrder(String id);
    String saveOrder(OrderApi orderApi);
    void deleteOrder(String id);
    List<OrderApi> getAllOrders();
}
