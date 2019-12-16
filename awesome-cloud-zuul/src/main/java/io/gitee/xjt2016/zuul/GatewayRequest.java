package io.gitee.xjt2016.zuul;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GatewayRequest {

    private String url;

    private String method;

    private Object data;

}
