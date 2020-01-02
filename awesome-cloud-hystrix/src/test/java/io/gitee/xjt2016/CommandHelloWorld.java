package io.gitee.xjt2016;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandHelloWorld extends HystrixCommand<String> {
    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
        System.out.println("CommandHelloWorld Construct");
    }

    @Override
    protected String run() throws Exception {
        int i = 1 / 0;
        return "Hello " + name + "!";
    }

    /**
     * 降级。Hystrix会在run()执行过程中出现错误、超时、线程池拒绝、断路器熔断等情况时，
     * 执行getFallBack()方法内的逻辑
     */
    @Override
    protected String getFallback() {
        return "fallback";
    }
}
