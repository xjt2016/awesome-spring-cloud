package io.gitee.xjt2016;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 4444100333430842324L;
    private int status;
    private String message;
    private T data;

    public Response(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response() {
    }
}
