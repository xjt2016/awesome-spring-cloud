package io.gitee.xjt2016;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Resource
    ApplicationContext context;

    @RequestMapping("/base/hi")
    public Response home(@RequestParam(value = "name", defaultValue = "forezp") String name, Integer age, String alias) {
        Map<String, String> data = new HashMap<>();
        data.put("message", "hi " + name + " ,i am from port:" + port);
        return new Response<>(data);
    }

    @ResponseBody
    @RequestMapping(value = {"/hi"})
    public Object hi(HttpServletRequest request, String username, String password) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = {"/server"})
    public Object server(HttpServletRequest request, String username, String password) throws Exception {
        return context.getBean(RibbonLoadBalancerClient.class).choose("LCPT-GATEWAY-BOOTSTRAP");
    }
}
