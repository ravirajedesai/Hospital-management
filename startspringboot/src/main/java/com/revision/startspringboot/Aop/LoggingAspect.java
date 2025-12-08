package com.revision.startspringboot.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.revision.startspringboot.Controller.Controller.addUser(..)) ||execution(* com.revision.startspringboot.Controller.Controller.addUser(..))")
    public void getMethodCall(JoinPoint jp){
        LOGGER.info("Method Called:"+jp.getSignature().getName());
    }
    @After("execution(* com.revision.startspringboot.Controller.Controller.addUser(..)) ||execution(* com.revision.startspringboot.Controller.Controller.addUser(..))")
    public void getMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed:"+jp.getSignature().getName());
    }
}
