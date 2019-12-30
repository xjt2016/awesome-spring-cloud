package io.gitee.xjt2016;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    private static final long serialVersionUID = 4444100333430842324L;
    private int status;
    private String message;
    private Object data;

    public Response(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response() {
    }
}
