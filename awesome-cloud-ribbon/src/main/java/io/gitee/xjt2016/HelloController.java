package io.gitee.xjt2016;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    HelloService helloService;


    @Resource
    ApplicationContext context;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @GetMapping(value = "/beans2")
    public String beans(@RequestParam String name) {
        return JSON.toJSONString(context.getBeanDefinitionNames());
    }
}


