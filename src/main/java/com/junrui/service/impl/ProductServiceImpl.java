package com.junrui.service.impl;

import com.junrui.entity.Product;
import com.junrui.entity.ProductClick;
import com.junrui.mapper.iProductMapper;
import com.junrui.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements iProductService {
    @Autowired
    private iProductMapper productMapper;

    @Override
    public List<Product> findAllProduct() {
        return productMapper.selectAllProduct();
    }

    @Override
    public List<ProductClick> findProductClick() {
        return productMapper.selectProductClick();
    }
}
