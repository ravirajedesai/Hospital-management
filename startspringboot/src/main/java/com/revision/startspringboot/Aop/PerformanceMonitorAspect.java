package com.revision.startspringboot.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.revision.startspringboot.Controller.Controller.getAllUser(..))")
    public void monitorTime(JoinPoint jp){
        long start=System.currentTimeMillis();

        jp.getSignature().getName();

        long end= System.currentTimeMillis();
        LOGGER.info("Time taken: "+(end-start)+"ms");


    }
}
