package io.gitee.xjt2016;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/hello")
public class HelloController {
    @ResponseBody
    @RequestMapping(value = {"/hi"})
    public Object hi() throws Exception {

        return "hi";
    }
}
