package io.gitee.xjt2016.modules.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * AutoZipkinEnvironmentPostProcessor.
 * 如果有多个项目需要：需要加入监控；则引入当前模块；完成了如下操作；
 * 1. 引入了zipkin、sleuth相关jar
 * 2. 传入了相关属性，将链路日志推送给了kafka
 *
 * @author xiongjinteng@gmail.com
 */
public class AutoZipkinEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Properties properties = new Properties();
        properties.setProperty("spring.zipkin.base-url", "http://192.168.51.100:9411");
        properties.setProperty("spring.zipkin.sender.type", "kafka");
        properties.setProperty("spring.kafka.bootstrap-servers", "192.168.51.100:9092");

        properties.setProperty("spring.sleuth.sampler.probability", "1.0");
        properties.setProperty("logging.level.org.springframework.web", "debug");

        PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("zipkin-auto", properties);
        environment.getPropertySources().addLast(propertiesPropertySource);
    }
}