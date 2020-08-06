package com.cncs.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志记录类
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置....");
    }


    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常....");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("后置....");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终....");
    }

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
