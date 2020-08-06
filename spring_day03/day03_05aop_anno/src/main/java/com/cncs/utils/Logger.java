package com.cncs.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志记录类
 */
@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution(* com.cncs.service.impl.*.*(..))")
    public void pt1(){}

    /**
     * 前置通知
     */
//    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置....");
    }


    /**
     * 异常通知
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("异常....");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("后置....");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("最终....");
    }


    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        //设置返回值
        Object returnVal = null;
        //获取参数
        Object[] args = pjp.getArgs();
        try{
            System.out.println("环绕通知....前置");
            returnVal = pjp.proceed(args);
            System.out.println("环绕通知....后置");
            return returnVal;
        }catch (Exception e){
            System.out.println("环绕通知....异常");
            throw new RuntimeException();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕通知....最终");
        }
        return null;
    }
}
