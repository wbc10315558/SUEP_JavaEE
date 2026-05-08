package com.demo.config;
import com.demo.common.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHander {
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e){
        return Result.error(e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return Result.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
