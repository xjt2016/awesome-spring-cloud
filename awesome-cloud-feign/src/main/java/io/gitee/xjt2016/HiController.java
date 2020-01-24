package io.gitee.xjt2016;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HiController {


    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Resource
    FeignServiceHi feignServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return feignServiceHi.hi4Post(name);
    }
}


