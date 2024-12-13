package com.codemind.pms.productservice.service;

import com.codemind.pms.productservice.dto.ProductDTO;
import com.codemind.pms.productservice.entity.Product;
import com.codemind.pms.productservice.exception.ProductNotFoundException;
import com.codemind.pms.productservice.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor-based dependency injection
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Method to create a new product
    public Product createProduct(@Valid ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductCategory(productDTO.getProductCategory());
        product.setProductCompony(productDTO.getProductCompony());
        return productRepository.save(product);
    }

    // Method to fetch all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // Method to update an existing product
    public Product updateProduct(Long id, @Valid ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductCategory(productDTO.getProductCategory());
        product.setProductCompony(productDTO.getProductCompony());
        return productRepository.save(product);
    }

    // Method to delete a product
    public String deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)); // If not found, throw exception
        productRepository.delete(product);
        return "Product deleted successfully";  // Success message
    }
}
