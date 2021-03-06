package io.gitee.xjt2016;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ZipkinClientApplication {

    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientApplication.class, args);
    }

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    //在提交之前，修改span信息
//    @Bean
//    FinishedSpanHandler handlerOne() {
//        return new FinishedSpanHandler() {
//            @Override
//            public boolean handle(TraceContext traceContext, MutableSpan span) {
//                span.name("foo");
//                return true; // keep this span
//            }
//        };
//    }
//
//    @Bean
//    FinishedSpanHandler handlerTwo() {
//        return new FinishedSpanHandler() {
//            @Override
//            public boolean handle(TraceContext traceContext, MutableSpan span) {
//                span.name(span.name() + " bar");
//                return true; // keep this span
//            }
//        };
//    }

}
