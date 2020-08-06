package com.cncs.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    @Test
    public void buyProduct() {
        final Producer producer = new ProducerImpl();
        //厂家直销
//        producer.sale(5000f);
        //通过经销商
        Producer producerProxy = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 对代理对象方法进行增强，并执行该方法
             * @param proxy 被代理对象的引用
             * @param method 被代理对象正在执行的方法
             * @param args 被代理对象正在执行方法的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //被代理对象的方法的返回值
                Object returnVal = null;
                //获取参数
                float money = (float) args[0];
                //执行被代理对象的方法
                returnVal = method.invoke(producer, money * 0.7f);
                return returnVal;
            }
        });
        producerProxy.sale(1000f);
    }


}
