package io.gitee.xjt2016;

import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@RestController
public class IndexController {

    @Resource
    ApplicationContext applicationContext;

    @Resource
    RestTemplate restTemplate;

    @Resource
    SimpleRouteLocator simpleRouteLocator;

    @ResponseBody
    @RequestMapping(value = {"/gateway"})
    public Object gateway() throws Exception {
        //return restTemplate.getForObject("http://server-hi/hi?name=" + name, String.class);

//        Map<String, ZuulProperties.ZuulRoute> routeMap = applicationContext.getBean(ZuulProperties.class).getRoutes();
        //zuulRoute.getServiceId();
//        String url = "/api-a/";
//        String serviceId = routeMap.get("api-a").getServiceId();

        // simpleRouteLocator.getZuulRoute("/api-b/hi").getServiceId()

//        return restTemplate.getForObject("http://" + serviceId + "/hi?name=" + "", String.class);
        String url = "/api-a/hi";
        String serviceId = simpleRouteLocator.getMatchingRoute(url).getLocation();

        return restTemplate.getForObject("http://" + "service-hi" + "/hi", String.class, ((Supplier<Map<String, Object>>) () -> {
            Map<String, Object> map = new HashMap<>();
            map.put("name", 123);
            return map;
        }).get());
    }

    public void proxy(String url, String params) {
        Map<String, ZuulProperties.ZuulRoute> routeMap = applicationContext.getBean(ZuulProperties.class).getRoutes();

    }

}
