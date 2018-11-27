package com.junrui.entity;

public class ProductClick {
    private String productName;
    private String productClick;

    public ProductClick() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductClick() {
        return productClick;
    }

    public void setProductClick(String productClick) {
        this.productClick = productClick;
    }

    @Override
    public String toString() {
        return "ProductClick{" +
                "productName='" + productName + '\'' +
                ", productClick='" + productClick + '\'' +
                '}';
    }
}
