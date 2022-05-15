package com.example.demo.config.aspect;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Before("execution(* com.example.demo.user.controller.UserController.*(..))")
    public void loggerBefore(){
        logger.info("before");
    }

    @After("execution(* com.example.demo.user.controller.UserController.*(..))")
    public void loggerAfter(){
        logger.info("after");
    }

    @Around("execution(* com.example.demo.user.controller.UserController.*(..))")
    public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long beforeTimeMillis =System.currentTimeMillis();
        logger.info("Start" + proceedingJoinPoint.getSignature().getName() + " " + proceedingJoinPoint.getSignature().getDeclaringTypeName());
        Object result = proceedingJoinPoint.proceed();
        long afterTimeMillis =System.currentTimeMillis()-beforeTimeMillis;
        logger.info("after" + proceedingJoinPoint.getSignature().getName() + " " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + " "+ afterTimeMillis);
        return result;

    }
}
