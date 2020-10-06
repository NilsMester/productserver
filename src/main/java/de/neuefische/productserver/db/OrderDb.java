package de.neuefische.productserver.db;

import de.neuefische.productserver.model.Order;
import de.neuefische.productserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDb {

    private ArrayList<Order> orderList;

    public OrderDb() {
        this.orderList = new ArrayList<>(List.of(new Order("1", new ArrayList<>(List.of(new Product("tomate","Tomate"))))));
    }

    public List<Order> listOrder() {
        return orderList;
    }

    public Order placeOrder(List<Product> products) {
        Order newOrder = new Order(products);
        orderList.add(newOrder);
        return newOrder;
    }
}
