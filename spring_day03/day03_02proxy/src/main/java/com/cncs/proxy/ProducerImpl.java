package com.cncs.proxy;

public class ProducerImpl implements Producer {
    @Override
    public void sale(float money) {
        System.out.println("厂家卖出产品，得到钱："+money);
    }
}
