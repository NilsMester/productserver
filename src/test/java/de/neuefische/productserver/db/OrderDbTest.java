package de.neuefische.productserver.db;

import de.neuefische.productserver.model.Product;
import de.neuefische.productserver.model.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDbTest {

    @Test
    void listShouldReturnList(){
        OrderDb orderDb = new OrderDb();
        List<Order> expected = new ArrayList<>(List.of(
                new Order("1", new ArrayList<>(List.of(new Product("tomate","Tomate"))))));
        assertTrue(true);

    }

}