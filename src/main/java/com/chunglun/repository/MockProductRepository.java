package com.chunglun.repository;

import com.chunglun.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockProductRepository {
    private final List<Product> productDB = new ArrayList<Product>();

    @PostConstruct
    private void initDB() {
        productDB.add(new Product("A01", "Java", 1000));
        productDB.add(new Product("A02", "Kotlin", 2000));
        productDB.add(new Product("A03", "Type Script", 500));
        productDB.add(new Product("A04", "Go", 700));
    }

    public Product insert(Product product) {
        productDB.add(product);
        return product;
    }

    public Product replace(String id, Product product) {
        Optional<Product> productOp = this.find(id);
        productOp.ifPresent(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
        });
        return product;
    }

    public void delete(String id) {
        productDB.removeIf(p -> p.getId().equals(id));
    }

    public Optional<Product> find(String id) {
        return productDB.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
