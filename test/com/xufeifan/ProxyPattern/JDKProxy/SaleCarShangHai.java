package com.xufeifan.ProxyPattern.JDKProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName SaleCarShangHai
 * @Description TODO
 * @createTime 2022年02月18日 11:52:00
 */
public class SaleCarShangHai implements SaleCarAll{
    @Override
    public void saleCar() {
        System.out.println("处于上海进行卖车");
    }
}
