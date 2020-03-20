package io.gitee.xjt2016;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://awesome-cloud-eureka-client/base/hi?name=" + name, String.class);
    }
}

