package de.neuefische.productserver.service;

import de.neuefische.productserver.db.OrderDb;
import de.neuefische.productserver.db.ProductDb;
import de.neuefische.productserver.model.Order;
import de.neuefische.productserver.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class OrderServiceTest
{

    private ProductDb productDb = mock(ProductDb.class);
    private OrderDb orderDb= mock(OrderDb.class);
    OrderService orderService = new OrderService(productDb, orderDb);


    @Test
    @DisplayName("orderList() should return List od orders")
    void orderListTest(){
        //given
        Order order1 = new Order(List.of(new Product("tomate","Tomate")));
        when(orderDb.listOrder()).thenReturn(List.of(order1));
        //when
        List<Order> actual = orderService.orderList();
        //then
        assertThat(actual, is(new ArrayList<>(List.of(order1))));
    }

    @Test
    @DisplayName("placing correct order should return Order")
    void TestPlaceOrderCorrect(){
        //given
        Order order1 = new Order(List.of(new Product("tomate","Tomate")));
        List products = List.of(new Product("tomate","Tomate"));
        when(orderDb.placeOrder(products)).thenReturn(order1);
        when(productDb.containsAll(products)).thenReturn(true);
        //when
        Order actual = orderService.placeOrder(products);
        //then
        assertThat(actual, is(order1));

    }


}