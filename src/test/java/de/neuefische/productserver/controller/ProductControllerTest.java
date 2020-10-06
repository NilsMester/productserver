package de.neuefische.productserver.controller;

import de.neuefische.productserver.model.Product;
import de.neuefische.productserver.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductControllerTest {


    @Test
    public void testGetProductById() {
        //GIVEN
        String id = "tomate";
        Product expected = new Product("tomate","Tomate");
        ProductService service = mock(ProductService.class);
        ProductController controller = new ProductController(service);
        when(service.getProductById(id)).thenReturn(Optional.of(expected));
        //WHEN
        Product actual = controller.getProductByID(id);
        //THEN
        assertEquals(expected,actual);

    }

}