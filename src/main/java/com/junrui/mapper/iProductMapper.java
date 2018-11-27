package com.junrui.mapper;

import com.junrui.entity.Product;
import com.junrui.entity.ProductClick;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这里要注解，奇怪
 */
@Mapper
@Repository
public interface iProductMapper {

    public List<Product> selectAllProduct();

    public List<ProductClick> selectProductClick();
}
