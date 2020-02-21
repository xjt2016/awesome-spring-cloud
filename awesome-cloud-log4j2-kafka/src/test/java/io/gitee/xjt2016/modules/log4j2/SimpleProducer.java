package io.gitee.xjt2016.modules.log4j2;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SimpleProducer {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            log.info("Hello---" + System.currentTimeMillis());
            Thread.sleep(1000);
        }
    }

}