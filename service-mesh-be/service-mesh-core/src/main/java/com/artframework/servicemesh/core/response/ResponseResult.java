package com.artframework.servicemesh.core.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResponseResult<T> build(T data) {
        return build(0, "Successfully.", data);
    }

    public static <T> ResponseResult<T> build(Integer code, String message, T data) {
        return (ResponseResult<T>) ResponseResult.builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }
}
