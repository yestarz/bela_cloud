package com.belacloud.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.belacloud.api.demo.service.DemoService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@RequestMapping("/test")
public class TestController {

    @DubboReference
    private DemoService demoService;

    @GetMapping("/test")
    public String get(@RequestParam(name = "name") String name, HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ":" + request.getHeader(headerName));
        }
        long loginIdAsLong = StpUtil.getLoginIdAsLong();
        return demoService.sayHello(name) + ",loginUserId:" + loginIdAsLong;
    }
}
