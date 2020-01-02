package io.gitee.xjt2016;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "awesome-cloud-eureka-client")
public interface FeignServiceHi {
    @GetMapping(value = "/hi")
    String hi(@RequestParam(value = "name") String name);

    @GetMapping(value = "/hi")
    String hi2(Map<String, Object> params);

    @PostMapping(value = "/hi")
    String hi2Post(Map<String, Object> params);

    @GetMapping(value = "/hi")
    String hi3(HiParam hiParam);

    @PostMapping(value = "/hi")
    String hi3(@RequestParam(value = "hiParam") HiParam hiParam, @RequestParam(value = "hiParam2") HiParam param2);

    @PostMapping(value = "/hi")
    String hi3Post(HiParam hiParam);

    @PostMapping(value = "/hi")
    String hi3Post(HiParam hiParam, @RequestParam(value = "alias") String alias);

}




