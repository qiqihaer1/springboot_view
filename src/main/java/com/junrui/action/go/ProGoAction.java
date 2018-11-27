package com.junrui.action.go;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProGoAction {

    @RequestMapping("/product")
    public String say(){
        return "product";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
