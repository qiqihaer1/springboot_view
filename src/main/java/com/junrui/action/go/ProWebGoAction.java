package com.junrui.action.go;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProWebGoAction {

    @RequestMapping("/websocket_product")
    public String say(){
        return "websocket_product";
    }
}
