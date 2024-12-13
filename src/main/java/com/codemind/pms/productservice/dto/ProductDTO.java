package com.codemind.pms.productservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class ProductDTO {

    @NotEmpty(message = "Product name is required")
    private String productName;

    @Positive(message = "Price must be positive value")
    private double productPrice;

    private String productCategory;

    private String productCompony;

    // Constructor
    public ProductDTO() {
    }

    public ProductDTO(String productName, double productPrice, String productCategory, String productCompony) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productCompony = productCompony;
    }

    // Getters and Setters
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
