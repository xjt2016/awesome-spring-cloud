package io.gitee.xjt2016;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class HelloController {
    @ResponseBody
    @RequestMapping(value = {"/hi"})
    public Object hi(HttpServletRequest request) throws Exception {

        return "hi";
    }

    @ResponseBody
    @RequestMapping(value = {"/bta/trans"})
    public Object hi2(HttpServletRequest request) throws Exception {
        return new BufferedReader(new InputStreamReader(request.getInputStream())) .lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
