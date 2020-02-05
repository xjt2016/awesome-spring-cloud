package io.gitee.xjt2016;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class HelloController {
    @ResponseBody
    @RequestMapping(value = {"/hi"})
    public Object hi(HttpServletRequest request, String username, String password) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }
}
