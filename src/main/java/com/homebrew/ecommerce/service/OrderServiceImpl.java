package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.OrderApi;
import com.homebrew.ecommerce.infrastructure.OrderRepository;
import com.homebrew.ecommerce.infrastructure.ShoppingCartRepository;
import com.homebrew.ecommerce.infrastructure.UserAccountRepository;
import com.homebrew.ecommerce.util.OrderTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserAccountRepository userAccountRepository;
    private ShoppingCartRepository shoppingCartRepository;
    @Override
    public OrderApi getOrder(String id) {
        return OrderTransformer.toOrderApi(orderRepository.findById(id).get());
    }

    @Override
    public void saveOrder(OrderApi orderApi) {
        var userAccount = userAccountRepository.findById(orderApi.userAccountId()).get();
        var shoppingCart = shoppingCartRepository.findById(orderApi.shoppingCartId()).get();
        var order = OrderTransformer.toOrder(orderApi, userAccount, shoppingCart);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderApi> getAllOrders() {
        return orderRepository.findAll().stream().map(OrderTransformer::toOrderApi).toList();
    }
}
