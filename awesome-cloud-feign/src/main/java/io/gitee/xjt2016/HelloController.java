package io.gitee.xjt2016;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@FeignClient(value = "123")
@RequestMapping(value = "/hello")
public interface HelloController {
    @ResponseBody
    @RequestMapping(value = {"/hi"})
    public Object hi();
}
