package io.gitee.xjt2016;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * https://javadoc.io/static/org.mockito/mockito-core/3.1.0/org/mockito/Mockito.html.
 *
 * @author xiongjinteng@gmail.com
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Test
    public void test001() throws Exception {
        log.info("hello");
    }
}