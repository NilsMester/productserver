package de.neuefische.productserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private ArrayList<Product> products;

    public Order(List<Product> products) {
        this.id = UUID.randomUUID().toString();
        this.products = new ArrayList<>(products);
    }
}
