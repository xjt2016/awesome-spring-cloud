package io.gitee.xjt2016;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Log4j2
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class SleuthZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinApplication.class, args);
    }

    @Value("${server.port}")
    String port;


    @Resource
    FeignServiceHi feignServiceHi;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return feignServiceHi.hi(name);
    }

}
