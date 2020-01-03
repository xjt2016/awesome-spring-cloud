package io.gitee.xjt2016;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceFeignApplicationTest {

    @Resource
    FeignServiceHi feignServiceHi;

    @Test
    public void test001() throws Exception {
        String result = (feignServiceHi.hi("xjt2016"));
        log.info(result);
    }

    @Test
    public void test002() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("name", "xjt2016");
        String result = (feignServiceHi.hi2(param));
        log.info(result);
    }

    @Test
    public void testhi2Post() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("name", "xjt2016");
        String result = (feignServiceHi.hi2Post(param));
        log.info(result);
    }

    @Test
    public void testhi3() throws Exception {
        String result = (feignServiceHi.hi3(new HiParam("xjt2016")));
        log.info(result);
    }

    @Test
    public void testhi32() throws Exception {
        String result = (feignServiceHi.hi3(new HiParam("xjt2016"), new HiParam("xjt2017")));
        log.info(result);
    }

    @Test
    public void hi3Post() throws Exception {
        String result = feignServiceHi.hi3Post(new HiParam("xjt2016"));
        log.info(result);
    }

    @Test
    public void hi3Post2() throws Exception {
        String result = feignServiceHi.hi3Post(new HiParam("xjt2016", "alaasas"), "alias2016");
        log.info(result);
    }


    @Resource
    FeignServiceHi2 feignServiceHi2;

    @Test
    public void testRibbonQuestion() throws Exception {
        log.info(feignServiceHi.hi("123"));
        log.info(feignServiceHi2.hi("123"));
        log.info(feignServiceHi.hi("123"));
        log.info(feignServiceHi2.hi("123"));
    }

    @Resource
    DiscoveryClient discoveryClient;

    @Test
    public void testEurekaClient() throws Exception {
        discoveryClient.getServices().forEach(log::info);
    }
}