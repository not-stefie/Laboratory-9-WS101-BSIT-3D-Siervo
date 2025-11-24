package com.Siervo.Lab7;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();
    private Long nextId = 4L;

    public ProductService() {
        // Initialize with three mock products
        products.put(1L, new Product(1L, "Drawing Pencils", 899.20));
        products.put(2L, new Product(2L, "High End Laptop", 69999.99));
        products.put(3L, new Product(3L, "Mechanical Pen", 899.90));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    // Get a product by ID
    public Product getProductById(Long id) {
        return products.get(id);
    }

    // Add a new product
    public Product addProduct(Product product) {
        product.setField_id(nextId++);
        products.put(product.getField_id(), product);
        return product;
    }

    // Update an existing product
    public Product updateProduct(Long id, Product updatedProduct) {
        if (!products.containsKey(id)) {
            return null;
        }
        updatedProduct.setField_id(id);
        products.put(id, updatedProduct);
        return updatedProduct;
    }

    // Delete a product
    public boolean deleteProduct(Long id) {
        return products.remove(id) != null;
    }
}
