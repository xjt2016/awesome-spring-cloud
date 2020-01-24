package io.gitee.xjt2016;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class HelloController {
    @ResponseBody
    @RequestMapping(value = {"/hi"})
    public Object hi(HttpServletRequest request) throws Exception {

        return "hi";
    }
}
