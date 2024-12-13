package com.codemind.pms.productservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private double productPrice;
    private String productCategory;
    private String productCompony;

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(String productName, double productPrice, String productCategory, String productCompony) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productCompony = productCompony;
    }

    public Product(long l, String testProduct, double v, String category1, String company1) {
    }

    public Product(int i, String product1, String description, double v, int i1, String category) {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCompony() {
        return productCompony;
    }

    public void setProductCompony(String productCompony) {
        this.productCompony = productCompony;
    }
}
