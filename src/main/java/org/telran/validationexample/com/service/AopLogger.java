package org.telran.validationexample.com.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopLogger {

//    @Before("execution(* org.telran.validationexample.com.service..*.*(..))")
//    public  void beforeAdvice(){
//        System.out.println("Hello!!!");
//    }
//
//    @After("execution(* org.telran.validationexample.com.service..*.*(..))")
//    public  void afterAdvice(){
//        System.out.println("After Hello!!!");
//    }

    @Before("execution(* org.telran.validationexample.com.service..*.*(..))")
    public  void advice(JoinPoint joinPoint){
        System.out.println("Method called " + joinPoint);
    }

    @AfterReturning(value = "execution(* org.telran.validationexample.com.service..*.*(..))", returning = "result")
    public  void adviceAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("Method called " + joinPoint + " result is " + result);
    }

    @AfterThrowing(value = "execution(* org.telran.validationexample.com.service..*.*(..))", throwing = "result")
    public  void adviceAfterThrowing(JoinPoint joinPoint, Throwable result){
        System.out.println("Method called " + joinPoint + " exception is " + result);
    }

    @Around(value = "execution(* org.telran.validationexample.com.service..*.*(..))")
    public  Object adviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AROUND - Before method call " + joinPoint);
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("AROUND - After method call " + joinPoint + timeTaken);
        return returnValue;
    }
}
