package cn.wzz.interview2021.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Before("execution(public int cn.wzz.interview2021.spring.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("******** @Before我是前置通知MyAspect");
    }


    @After("execution(public int cn.wzz.interview2021.spring.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("******** @After我是后置通知");
    }


    @AfterReturning("execution(public int cn.wzz.interview2021.spring.CalcServiceImpl.*(..))")
    public void afterReturningNotify() {
        System.out.println("********@AfterReturning我是返回后通知");
    }


    @AfterThrowing("execution(public int cn.wzz.interview2021.spring.CalcServiceImpl.*(..))")
    public void afterThrowingNotify() {
        System.out.println("********@AfterThrowing我是异常通知");
    }


    @Around("execution(public int cn.wzz.interview2021.spring.CalcServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue = null;
        System.out.println("我是环绕通知之前AAA");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知之后BBB");
        return retValue;
    }
}