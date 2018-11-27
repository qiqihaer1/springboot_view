package com.junrui.vo;

import java.util.Arrays;

public class ProductClickVo {
    private String[] productName;
    private String[] productClick;

    public ProductClickVo() {
    }

    public String[] getProductName() {
        return productName;
    }

    public void setProductName(String[] productName) {
        this.productName = productName;
    }

    public String[] getProductClick() {
        return productClick;
    }

    public void setProductClick(String[] productClick) {
        this.productClick = productClick;
    }

    @Override
    public String toString() {
        return "ProductClickVo{" +
                "productName=" + Arrays.toString(productName) +
                ", productClick=" + Arrays.toString(productClick) +
                '}';
    }
}
