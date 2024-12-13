package com.codemind.pms.productservice.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductDefaultConstructor() {
        Product product = new Product();

        assertNotNull(product);
        assertNull(product.getId());
        assertNull(product.getProductName());
        assertEquals(0.0, product.getProductPrice());
        assertNull(product.getProductCategory());
        assertNull(product.getProductCompony());
    }

    @Test
    void testProductParameterizedConstructor() {
        Product product = new Product("Test Product", 99.99, "Category1", "Company1");

        assertNotNull(product);
        assertNull(product.getId()); // ID is not set in this case
        assertEquals("Test Product", product.getProductName());
        assertEquals(99.99, product.getProductPrice());
        assertEquals("Category1", product.getProductCategory());
        assertEquals("Company1", product.getProductCompony());
    }

    @Test
    void testSettersAndGetters() {
        Product product = new Product();

        product.setId(1L);
        product.setProductName("Updated Product");
        product.setProductPrice(49.99);
        product.setProductCategory("Updated Category");
        product.setProductCompony("Updated Company");

        assertEquals(1L, product.getId());
        assertEquals("Updated Product", product.getProductName());
        assertEquals(49.99, product.getProductPrice());
        assertEquals("Updated Category", product.getProductCategory());
        assertEquals("Updated Company", product.getProductCompony());
    }
}
