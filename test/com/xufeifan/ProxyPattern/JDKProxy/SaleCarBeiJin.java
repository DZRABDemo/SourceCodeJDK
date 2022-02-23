package com.xufeifan.ProxyPattern.JDKProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName SaleCarBeiJing
 * @Description TODO
 * @createTime 2022年02月18日 11:53:00
 */
public class SaleCarBeiJin implements SaleCarAll{

    @Override
    public void saleCar() {
        System.out.println("处于北京进行卖车");
    }
}
