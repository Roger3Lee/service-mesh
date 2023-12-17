package com.artframework.servicemesh.core.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResponseResult<T> build(T data) {
        return build(0, "Successfully.", data);
    }

    public static <T> ResponseResult<T> build(Integer code, String message, T data) {
        ResponseResult<T> response = new ResponseResult<T>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
