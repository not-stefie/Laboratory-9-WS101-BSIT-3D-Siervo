package com.Siervo.Lab7;

import com.Siervo.Lab7.service.ProductService;
import com.Siervo.Lab7.entity.Product;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class ProductGraphQLController {

    private final ProductService productService;

    public ProductGraphQLController(ProductService productService) {
        this.productService = productService;
    }


    // Maps to the 'allProducts' Query in the schema
    @QueryMapping
    public List<Product> allProducts() {
        return productService.getAllProducts();
    }

    // Maps to the 'productById' Query in the schema
    @QueryMapping
    public Product productById(@Argument Long id) {
        return productService.getProductById(id);
    }


    // Maps to the 'createProduct' Mutation
    @MutationMapping
    public Product createProduct(@Argument String name, @Argument Double price) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        return productService.addProduct(newProduct);
    }

    // Maps to the 'updateProduct' Mutation
    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument String name, @Argument Double price) {
        Product updatedProduct = new Product();
        updatedProduct.setName(name);
        updatedProduct.setPrice(price);
        return productService.updateProduct(id, updatedProduct);
    }

    // Maps to the 'deleteProduct' Mutation
    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }
}
