package de.neuefische.productserver.db;

import de.neuefische.productserver.model.Product;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDb {

    private List<Product> productList;

    public ProductDb() {
        this.productList = new ArrayList<>(List.of(new Product("gemüse","Gemüse"),new Product("tomate","Tomate")));
    }

    public List<Product> productList() {
        return productList;
    }

    public Optional<Product> getProductById(String id) {
        for (Product product: productList) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public Optional<Product> putProduct(Product product) {

        if (isIdTaken(product.getId())) {
            return Optional.empty();
        }

        if (productList.add(product)) {
            return Optional.of(product);
        }
        return Optional.empty();

    }

    private boolean isIdTaken(String id) {
        for (Product product: productList) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    public boolean containsAll(List<Product> products) {
        for (Product product: products) {
            if(!productList.contains(product)) {
                return false;
            }
        }
        return true;
    }
}
