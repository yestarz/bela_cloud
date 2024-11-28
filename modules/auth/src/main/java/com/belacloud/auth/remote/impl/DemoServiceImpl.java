package com.belacloud.auth.remote.impl;

import com.belacloud.api.demo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@DubboService
@RefreshScope
public class DemoServiceImpl implements DemoService {

    private String name;

    @Value("${app.client-id}")
    private String clientId;

    @Value("${server.port}")
    private String port;

    @Override
    public String sayHello(String name) {
        return "Hello " + name + ",clientId=" + clientId + ".port=" + port;
    }
}
