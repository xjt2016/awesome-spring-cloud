package io.gitee.xjt2016;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "awesome-cloud-eureka-client2")
public interface FeignServiceHi2 {
    @GetMapping(value = "/hi")
    String hi(@RequestParam(value = "name") String name);

}




