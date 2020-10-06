package de.neuefische.productserver.service;

import de.neuefische.productserver.db.ProductDB;
import de.neuefische.productserver.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDB productDB;

    public ProductService(ProductDB productDB) {
        this.productDB = productDB;
    }

    public List<Product> productList() {
        return productDB.productList();
    }

    public Optional<Product> getProductById(String id) {
        return productDB.getProductById(id);
    }

    public Optional<Product> putProduct(Product product) {
        return productDB.putProduct(product);
    }
}
