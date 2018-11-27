package com.junrui.websocket;

import com.alibaba.fastjson.JSON;
import com.junrui.entity.ProductClick;
import com.junrui.service.iProductService;
import com.junrui.vo.ProductClickVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.List;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {


    @Autowired
    iProductService productService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        while(true){
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
            //创建json对象字符串
            String jsons = JSON.toJSONString(vo);
            System.out.println(jsons+"----------------");
            //发送json字符串到websocket，3秒一次
            session.sendMessage(new TextMessage(jsons));
            Thread.sleep(3000);
        }
    }


}

