package io.gitee.xjt2016;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}


