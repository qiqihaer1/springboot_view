package com.junrui.action;

import com.junrui.entity.ProductClick;
import com.junrui.service.iProductService;
import com.junrui.vo.ProductClickVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProClickAction {
    @Autowired
    private iProductService productService;

    @RequestMapping("/productClick")
    @ResponseBody
    public ProductClickVo click(){
        //获取数据
        List<ProductClick> products = productService.findProductClick();
        System.out.println(products);
        //构造数据结构为2个数组
        String[] dataX=new String[products.size()];
        String[] dataY=new String[products.size()];
        for (int i=0;i<products.size();i++){
            dataX[i] = products.get(i).getProductName();
            dataY[i] = products.get(i).getProductClick();
        }
        ProductClickVo vo = new ProductClickVo();
        vo.setProductName(dataX);
        vo.setProductClick(dataY);
        System.out.println(vo);
        return vo;

    }
}
