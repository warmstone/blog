package com.ballcat.blog.aop;

import io.swagger.annotations.Api;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pengshun
 * @date 2022-04-10 17:20
 * @description
 */
@Aspect
@Configuration
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日志切点
     */
    @Pointcut(value = "execution(public * com.ballcat.blog.controller.*.* (*))")
    public void log() {}

    @Around(value = "log()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("============================================== Start ==============================================");
        long startTime = System.currentTimeMillis();
        logger.info("URL:               {}", request.getRequestURL().toString());
        logger.info("HTTP Method:       {}", request.getMethod());
        logger.info("Class Method:      {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("IP:                {}", request.getRemoteAddr());
        logger.info("Request Params:    {}", joinPoint.getArgs());
        Object result = joinPoint.proceed();
        logger.info("Response Result:   {}", result);
        long endTime = System.currentTimeMillis();
        logger.info("Time-Consuming:    {} ms", endTime - startTime);
        logger.info("============================================== End ==============================================");
        return result;
    }

}
