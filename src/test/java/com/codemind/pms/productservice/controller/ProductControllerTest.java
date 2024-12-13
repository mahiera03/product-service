package com.codemind.pms.productservice.controller;

import com.codemind.pms.productservice.dto.ProductDTO;
import com.codemind.pms.productservice.entity.Product;
import com.codemind.pms.productservice.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private static final String BASE_URL = "/api/products";  // Base URL for the controller

    @Mock
    private ProductService productService;  // Mocking ProductService

    @InjectMocks
    private ProductController productController;  // Inject the mock service into the controller

    private MockMvc mockMvc;
    private Product product;
    private ProductDTO productDTO;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();  // Setup MockMvc for controller testing
        product = new Product(1L, "Test Product", 100.0, "Test Category", "Test Company");
        productDTO = new ProductDTO("New Product", 200.0, "New Category", "New Company");
        objectMapper = new ObjectMapper();  // ObjectMapper to serialize objects to JSON
    }

    @Test
    void createProduct_ShouldReturnCreatedProduct() throws Exception {
        when(productService.createProduct(any(ProductDTO.class))).thenReturn(product);  // Mock service to return product

        // Perform POST request to create product and assert response
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDTO)))  // Sending productDTO as JSON
                .andExpect(status().isOk())  // Expect HTTP 200 OK status
                .andExpect(jsonPath("$.productName").value("Test Product"));  // Assert that product name is as expected

        // Verify that service method was called once
        verify(productService, times(1)).createProduct(any(ProductDTO.class));
    }

    @Test
    void getAllProducts_ShouldReturnListOfProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of(product));  // Mock service to return a list of products

        // Perform GET request and assert response
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())  // Expect HTTP 200 OK status
                .andExpect(jsonPath("$[0].productName").value("Test Product"));  // Assert that the first product name is as expected

        // Verify that service method was called once
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProductById_ShouldReturnProduct() throws Exception {
        when(productService.getProductById(1L)).thenReturn(product);  // Mock service to return product by ID

        // Perform GET request for product by ID and assert response
        mockMvc.perform(get(BASE_URL + "/product/1"))  // Using path variable for product ID
                .andExpect(status().isOk())  // Expect HTTP 200 OK status
                .andExpect(jsonPath("$.productName").value("Test Product"));  // Assert product name in the response

        // Verify that service method was called once
        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    void updateProduct_ShouldReturnUpdatedProduct() throws Exception {
        when(productService.updateProduct(eq(1L), any(ProductDTO.class))).thenReturn(product);  // Mock service to update product

        // Perform PUT request to update the product and assert response
        mockMvc.perform(put(BASE_URL + "/product/1")  // Using path variable for product ID
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDTO)))  // Sending updated productDTO as JSON
                .andExpect(status().isOk())  // Expect HTTP 200 OK status
                .andExpect(jsonPath("$.productName").value("Test Product"));  // Assert product name in the response

        // Verify that service method was called once
        verify(productService, times(1)).updateProduct(eq(1L), any(ProductDTO.class));
    }

    @Test
    void deleteProduct_ShouldReturnSuccessMessage() throws Exception {
        when(productService.deleteProduct(1L)).thenReturn("Product deleted successfully");  // Mock service to delete product

        // Perform DELETE request and assert response
        mockMvc.perform(delete(BASE_URL + "/product/1"))  // Using path variable for product ID
                .andExpect(status().isOk())  // Expect HTTP 200 OK status
                .andExpect(content().string("Product deleted successfully"));  // Assert success message

        // Verify that service method was called once
        verify(productService, times(1)).deleteProduct(1L);
    }
}
