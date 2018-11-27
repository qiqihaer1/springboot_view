package com.junrui.service;

import com.junrui.entity.Product;
import com.junrui.entity.ProductClick;

import java.util.List;

public interface iProductService {
    /**
     * 全局查询t_product表
     * @return
     */
    public List<Product> findAllProduct();
    /**
     * 全局查询t_product_click表
     * @return
     */
    public List<ProductClick> findProductClick();
}
