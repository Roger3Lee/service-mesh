package com.artframework.servicemesh.core.advice;

import com.alibaba.fastjson.JSON;
import com.artframework.servicemesh.core.annotations.ResponseNotIntercept;
import com.artframework.servicemesh.core.response.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.getDeclaringClass().isAnnotationPresent(ResponseNotIntercept.class)) {
            //若在类中加了@ResponseNotIntercept 则该类中的方法不用做统一的拦截
            return false;
        }
        if (Objects.requireNonNull(returnType.getMethod()).isAnnotationPresent(ResponseNotIntercept.class)) {
            //若方法上加了@ResponseNotIntercept 则该方法不用做统一的拦截
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
            if (body instanceof ResponseResult) {
            return body;
        }
        if (body instanceof String) {
            //解决返回值为字符串时，不能正常包装
            return JSON.toJSONString(ResponseResult.build(body));
        }
        return ResponseResult.build(body);
    }
}
