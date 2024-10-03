package com.example.hellospringboot.controller;

import com.example.hellospringboot.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private List<Product> products = new ArrayList<>();

    // Create a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        products.add(product);
        return product;
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
        Product product = products
                .stream().filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if(product!=null){
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
        }

        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        products.removeIf(product -> product.getId().equals(id));
        return "Product with id " + id + " has been deleted.";
    }
}
