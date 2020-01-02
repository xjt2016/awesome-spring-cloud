package io.gitee.xjt2016;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;

/**
 * descrption: 通过spring的LocalVariableTableParameterNameDiscoverer 获取方法的参数，spring也是通过使用ASM通过字节码获取方法中参数的具体的名称
 * authohr: wangji
 * date: 2017-08-15 10:20
 */
@Slf4j
public class GetMethArguments {

    private static final LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    public static void main(String[] args) {
        Method[] methods = FeignServiceHi.class.getMethods();
        for (Method method : methods) {
            String[] paraNames = parameterNameDiscoverer.getParameterNames(method);

            if (paraNames != null) {
                StringBuilder buffer = new StringBuilder();
                for (String string : paraNames) {
                    buffer.append(string).append("\t");
                }
                log.info("methodName:{},parameArguments:{}", method.getName(), buffer.toString());
            } else {
                log.info("methodName:{},无参数",method.getName());
            }
        }
    }

}
