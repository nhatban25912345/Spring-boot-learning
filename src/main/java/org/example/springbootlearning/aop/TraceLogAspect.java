package org.example.springbootlearning.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
@Slf4j
public class TraceLogAspect {
    @Around("execution(* org.example.springbootlearning.controller..*.*(..)) || " +
            "execution(* org.example.springbootlearning.service..*.*(..)) || " +
            "execution(* org.example.springbootlearning.service.*.*.*(..)) || " +
            "execution(* org.example.springbootlearning.repository.*.*.*(..))" )
    public Object traceLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String taskName = joinPoint.getSignature().getName();
        StopWatch sw = new StopWatch(taskName);
        try {
            sw.start(taskName);
            return joinPoint.proceed();
        } finally {
            sw.stop();
            log.info("TIME TRACER: {}: running time = {} ms", taskName, sw.getTotalTimeMillis());
        }
    }

}
