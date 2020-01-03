package io.gitee.xjt2016;

import com.alibaba.fastjson.JSON;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceRibbonApplicationTest {

    @Resource
    HelloService helloService;

    @Test
    public void test001() throws Exception {
        String response = helloService.hiService("xjt2016");
        log.info(response);
    }

    @Resource
    ApplicationContext ctx;

    @Test
    public void testGetServerList() throws Exception {
        String serverId = "awesome-cloud-eureka-client";
        SpringClientFactory springClientFactory = ctx.getBean(SpringClientFactory.class);
        ILoadBalancer loadBalancer = springClientFactory.getLoadBalancer(serverId);
        List<Server> servers = loadBalancer.getReachableServers();
        for (Server server : servers) {
            //如果服务有设置zone，此处获取的可能并不是所有的实例
            log.info(JSON.toJSONString(server));
        }

    }
}