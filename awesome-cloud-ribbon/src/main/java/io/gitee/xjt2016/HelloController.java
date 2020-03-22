package io.gitee.xjt2016;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    HelloService helloService;


    @Resource
    RestTemplate restTemplate;

    @Resource
    ApplicationContext context;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @GetMapping(value = "/beans2")
    public String beans(@RequestParam String name) {
        //LCPT-WEB-CONSOLE-INSURE
        return restTemplate.getForObject("http://lcpt-web-console-insure/hi?name=" + name, String.class);

    }
}


