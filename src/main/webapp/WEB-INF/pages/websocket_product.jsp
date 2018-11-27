<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
</head>
<body style="height: 100%; margin: 0">

<div id="container" style="height: 100%"></div>

<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<script type="text/javascript">
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '坐标轴刻度与标签对齐';


    option = {
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : [],
                axisTick: {
                    alignWithLabel: true
                },
                axisLabel:{
                    interval:0,//全显示
                    rotate:30//旋转

                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'直接访问',
                type:'bar',
                barWidth: '60%',
                data:[]
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
    //加入webSocket
    var socket = new WebSocket("ws://localhost:8080/websocket");
    //打开事件
    socket.onopen=function(){
        console.info("Socket已打开")
        socket.send("打开了！")
    }
    socket.onmessage=function(result){
        console.info(result)
//        console.info($.parseJSON(result))
        //赋值的容器
        dataX=[]
        dataY=[]
        //因为result是字符串，转换为JS值的Objcet对象
        var array = $.parseJSON(result.data);
            console.info(array.productName)
            console.info(array.productClick)
            var name = array.productName;
            var click = array.productClick;
            if (result) {
                for(i=0;i<name.length;i++){
                //使用result.length长度为1，因为result是一个对象！！！
                    dataX[i]=name[i]
                    dataY[i]=click[i]
                }
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    xAxis: {
                        data: dataX
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '销量',
                        data: dataY
                    }]
                });

            }

    }

</script>
</body>
</html>
