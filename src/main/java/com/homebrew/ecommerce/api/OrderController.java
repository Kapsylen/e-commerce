package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.OrderApi;
import com.homebrew.ecommerce.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderServiceImpl orderService;
    @GetMapping("/orders/{orderId}")
    @ResponseStatus(value = HttpStatus.OK)
    public OrderApi getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping("/orders")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addOrder(@RequestBody OrderApi orderApi) {
        orderService.saveOrder(orderApi);
    }
}
