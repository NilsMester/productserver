package de.neuefische.productserver.controller;

import de.neuefische.productserver.model.Product;
import de.neuefische.productserver.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> listProducts(){
        return productService.productList();
    }


    @GetMapping("{id}")
    public Product getProductByID(@PathVariable String id){
        Optional<Product> foundProduct = productService.getProductById(id);

        if (foundProduct.isPresent()) {
            return foundProduct.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public Product putProduct(@RequestBody Product product) {
        Optional<Product> returnProduct = productService.putProduct(product);

        if (returnProduct.isPresent()) {
            return returnProduct.get();
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }



}
