package io.gitee.xjt2016;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @ResponseBody
    @RequestMapping(value = {"/index", "", "/"})
    public Object index() throws Exception {
        return "Hello world";
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application start success");
    }
}