package com.codemind.pms.productservice.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOTest {

    @Test
    void testDefaultConstructor() {
        ProductDTO productDTO = new ProductDTO();

        assertNotNull(productDTO);
        assertNull(productDTO.getProductName());
        assertEquals(0.0, productDTO.getProductPrice());
        assertNull(productDTO.getProductCategory());
        assertNull(productDTO.getProductCompony());
    }

    @Test
    void testParameterizedConstructor() {
        ProductDTO productDTO = new ProductDTO("Test Product", 99.99, "Category1", "Company1");

        assertNotNull(productDTO);
        assertEquals("Test Product", productDTO.getProductName());
        assertEquals(99.99, productDTO.getProductPrice());
        assertEquals("Category1", productDTO.getProductCategory());
        assertEquals("Company1", productDTO.getProductCompony());
    }

    @Test
    void testSettersAndGetters() {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductName("New Product");
        assertEquals("New Product", productDTO.getProductName());

        productDTO.setProductPrice(120.5);
        assertEquals(120.5, productDTO.getProductPrice());

        productDTO.setProductCategory("New Category");
        assertEquals("New Category", productDTO.getProductCategory());

        productDTO.setProductCompony("New Company");
        assertEquals("New Company", productDTO.getProductCompony());
    }
}
