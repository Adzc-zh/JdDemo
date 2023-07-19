package com.jd.controller;


import cn.hutool.core.date.DateUtil;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.domain.kplunion.OrderService.request.query.OrderRowReq;
import com.jd.open.api.sdk.request.kplunion.UnionOpenOrderRowQueryRequest;
import com.jd.open.api.sdk.response.kplunion.UnionOpenOrderRowQueryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Adzc
 * @date 2023/7/19 22:29
 */
@RestController
public class Jdcontroller {


    @GetMapping("/a")
    public void test() throws Exception {
        System.out.println("hello");
        Date startTime = DateUtil.parseDateTime("2023-07-19 15:50:00");
        Date endTime   = DateUtil.parseDateTime("2023-07-19 15:53:00");
        String SERVER_URL = "https://api.jd.com/routerjson";
        String accessToken="";
        String appKey = "82ad36116686021fe01a75083e609eb9";
        String appSecret="065e4d312e0e4f83ab396dcd565eb963";

        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
        UnionOpenOrderRowQueryRequest request=new UnionOpenOrderRowQueryRequest();
        OrderRowReq orderReq=new OrderRowReq();
        orderReq.setEndTime(endTime.toString());
        orderReq.setStartTime(startTime.toString());
        System.out.println(orderReq);
        request.setOrderReq(orderReq);
        UnionOpenOrderRowQueryResponse response=client.execute(request); //向京东发起请求
        System.out.println(response.getQueryResult().getData());
    }
}
