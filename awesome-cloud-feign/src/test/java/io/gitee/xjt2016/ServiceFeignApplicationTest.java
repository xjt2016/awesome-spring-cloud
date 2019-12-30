package io.gitee.xjt2016;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceFeignApplicationTest {

    @Resource
    FeignServiceHi feignServiceHi;

    @Test
    public void test001() throws Exception {
        String result = (feignServiceHi.sayHiFromClientOne("xjt2016"));
        log.info(result);
    }
}