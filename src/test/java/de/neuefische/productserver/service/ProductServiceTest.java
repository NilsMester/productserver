package de.neuefische.productserver.service;

import de.neuefische.productserver.db.ProductDb;
import de.neuefische.productserver.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    ProductDb productDB = mock(ProductDb.class);
    ProductService productService= new ProductService(productDB);
    @Test
    public void listShouldReturnMatchingList(){
        //given
        List<Product> products = new ArrayList<>(List.of(
                new Product("gemüse","Gemüse"),
                new Product("tomate","Tomate")
        ));
        when(productDB.productList()).thenReturn(products);
        //when
        List<Product> actual = productService.productList();
        assertThat(actual, is(products));

    }

    @Test
    void getProductByIdShouldReturnMatchingProduct(){
        //given
        String id ="gemüse";
        when(productDB.getProductById(id)).thenReturn(
                Optional.of(new Product("gemüse","Gemüse"))
        );
        //when
        Optional<Product> actual = productService.getProductById(id);
        //then
        assertThat(actual,is(
                Optional.of(new Product("gemüse","Gemüse")))
        );
    }

    @Test
    void getProductByIdShouldEmptyOptionalWhenGivenWrongId(){
        //given
        String id ="salat";
        when(productDB.getProductById(id)).thenReturn(Optional.empty());
        //when
        Optional<Product> actual = productService.getProductById(id);
        //then
        assertEquals(actual,Optional.empty());
    }

    @Test
    void putProductShouldReturnProduct(){
        //given
        Product product = new Product("käse","Käse");
        when(productDB.putProduct(product)).thenReturn(Optional.of(product));
        //when
        Optional<Product> actual = productService.putProduct(product);
        //then
        assertThat(actual, is(Optional.of(new Product("käse","Käse"))));
        verify(productDB).putProduct(product); //schnickschnack
    }

    @Test
    @DisplayName("putProductShouldReturnEmptyOptionalIfGivenProductWithExistingId")
    void putProductTestGivenID(){
        Product product= new Product("gemüse","Gemüse");
        when(productDB.putProduct(product)).thenReturn(Optional.empty());
        //when
        Optional<Product> actual = productService.putProduct(product);
        //then
        assertThat(actual, is(Optional.empty()));


    }




}