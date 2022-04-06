package com.ballcat.blog.handler;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pengshun
 * @date 2022-04-06 22:16
 * @description 全局异常处理器
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求参数校验异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult<String> methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException exception) {
        log.error("请求参数校验错误，请求方法：{}，参数：{}", exception.getParameter().getMethod().getName(), exception.getBindingResult().getFieldError().getDefaultMessage());
        return CommonResult.fail(exception.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 请求参数序列化错误处理
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public CommonResult<String> httpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException exception) {
        log.error(exception.getMessage());
        return CommonResult.fail(exception.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public CommonResult<String> methodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException exception) {
        log.error("参数类型错误，参数名：{}", exception.getName());
        return CommonResult.fail("参数类型错误，参数名" + exception.getName());
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResult<String> bindExceptionHandler(HttpServletRequest request, BindException exception) {
        log.error("参数类型错误，参数名：{}", exception.getBindingResult());
        return CommonResult.fail("参数类型错误");
    }

    @ResponseBody
    @ExceptionHandler(BizException.class)
    public CommonResult<String> bizExceptionHandler(BizException e) {
        log.info("捕获业务异常: {}", e.getMessage());
        return CommonResult.fail(e.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult<String> exceptionHandler(Exception e) {
        log.info("捕获未定义异常: {}", e.getMessage());
        return CommonResult.fail(e.getMessage());
    }


}
