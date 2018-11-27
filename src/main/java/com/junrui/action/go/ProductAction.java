package com.junrui.action.go;

import com.junrui.entity.Product;
import com.junrui.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
public class ProductAction {
    @Autowired
    private iProductService productService;

    @RequestMapping("/say1")
    public String say(){
        System.out.println("springboot测试");
        List<Product> products = productService.findAllProduct();
        System.out.println(products);
        for (Product product:products){
            System.out.println(product);
        }
        return "hello";
    }
}
