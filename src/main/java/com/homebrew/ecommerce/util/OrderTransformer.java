package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.OrderApi;
import com.homebrew.ecommerce.domain.ShoppingCart;
import com.homebrew.ecommerce.infrastructure.entity.Order;
import com.homebrew.ecommerce.infrastructure.entity.UserAccount;

import java.util.UUID;

public class OrderTransformer {

    public static OrderApi toOrderApi(Order order) {
        return OrderApi.builder()
                .created(order.getCreatedDateTime())
                .updated(order.getUpdatedDateTime())
                .build();
    }

    public static Order toOrder(OrderApi orderApi, UserAccount userAccount, ShoppingCart shoppingCart) {
        return new Order(UUID.randomUUID().toString(), orderApi.created(), orderApi.updated(), userAccount, shoppingCart);
    }
}