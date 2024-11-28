package com.belacloud.system;

import com.belacloud.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.belacloud")
@EnableDubbo
public class SystemApplication implements CommandLineRunner {

    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(demoService.sayHello("world!"));
    }
}
