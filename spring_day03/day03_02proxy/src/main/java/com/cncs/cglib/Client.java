package com.cncs.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import java.lang.reflect.Method;

public class Client {

    @Test
    public void buyProduct() {
        final ProducerImpl producer = new ProducerImpl();
        //厂家直销
//        producer.sale(5000f);
        //通过经销商
        ProducerImpl producerCglib = (ProducerImpl) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //返回值
                Object returnVal = null;
                //获得参数
                float money = (float) objects[0];
                returnVal = method.invoke(producer,money*0.7f);
                return returnVal;
            }
        });
        producerCglib.sale(1000f);
    }


}
