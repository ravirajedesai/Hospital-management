package com.dataJpa.springBootDataJpa.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspects.class);

    @Before("execution(* com.dataJpa.springBootDataJpa.ser.StudentServiceImpl.*(..))")
    public void logMethodCall(){
        LOGGER.info("Method Called.");
    }
}
