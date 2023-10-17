package com.chunglun.service;

import com.chunglun.entity.Product;
import com.chunglun.object.NotFoundException;
import com.chunglun.object.UnprocessableEntityException;
import com.chunglun.repository.MockProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private MockProductRepository productRepository;

    public Product createProduct(Product request) {
        boolean isIdDuplicated = productRepository.find(request.getId()).isPresent();
        if (isIdDuplicated) {
            throw new UnprocessableEntityException("The id of the product is duplicated.");
        }
        Product product = new Product(request.getId(), request.getName(), request.getPrice());
        return productRepository.insert(product);
    }

    public Product getProduct(String id) {
        return productRepository.find(id)
                .orElseThrow(() -> new NotFoundException("Can't find product."));
    }

    public Product replaceProduct(String id, Product request) {
        Product product = this.getProduct(id);
        return productRepository.replace(product.getId(), request);
    }

    public void deleteProduct(String id) {
        Product product = this.getProduct(id);
        productRepository.delete(product.getId());
    }
}
