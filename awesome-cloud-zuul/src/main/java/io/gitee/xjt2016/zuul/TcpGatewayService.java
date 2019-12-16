package io.gitee.xjt2016.zuul;


import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;


public class TcpGatewayService {

    private ApplicationContext applicationContext;

    private RestTemplate restTemplate;

    private SimpleRouteLocator simpleRouteLocator;

    public TcpGatewayService(ApplicationContext applicationContext, RestTemplate restTemplate, SimpleRouteLocator simpleRouteLocator) {
        this.applicationContext = applicationContext;
        this.restTemplate = restTemplate;
        this.simpleRouteLocator = simpleRouteLocator;
    }

    //CommandLineRunner启动端口监听tcp
    public void exchange() {

        //请求参数为tcp的数据流

        //转换为url[],header[token],params[key,value],type[get/post]

        Map<String, Object> params = new HashMap<>();

        //匹配url，获取serviceId
        String serviceId = "service-hi";
        String urlSuffix = "/hi";
        String url = MessageFormat.format("http://{0}{1}", serviceId, urlSuffix);
        Map<String, Object> response = restTemplate.postForObject(url, params, Map.class);
    }

}
