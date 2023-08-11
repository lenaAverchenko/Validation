package org.telran.validationexample.com.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {

    @Around(value = "execution(* org.telran.validationexample.com.service.TransferServiceImpl.*(..))")
    public Object adviseAroundTransaction(ProceedingJoinPoint joinPoint){
        try{
            System.out.println("Start transfer: " + joinPoint);
            Object returnValue = joinPoint.proceed();
            System.out.println("Result transfer: " + joinPoint);
            return returnValue;
        } catch (IllegalArgumentException ex){
            System.out.println("error: " + ex.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
