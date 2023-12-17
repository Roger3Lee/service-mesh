package com.artframework.servicemesh.core.advice;

import com.artframework.servicemesh.core.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseResult<Object> exception(Exception ex){
        log.error("Exception:",ex);
        return ResponseResult.build(500,"unknown exception", null);
    }
}
