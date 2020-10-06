package de.neuefische.productserver.controller;

import de.neuefische.productserver.model.Order;
import de.neuefische.productserver.model.Product;
import de.neuefische.productserver.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> listOrders(){
        return orderService.orderList();
    }

    @PutMapping
    public Order placeOrder(@RequestBody List<Product> products) {
        return orderService.placeOrder(products);
    }

}
