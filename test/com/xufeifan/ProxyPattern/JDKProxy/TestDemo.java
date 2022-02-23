package com.xufeifan.ProxyPattern.JDKProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestDemo
 * @Description TODO
 * @createTime 2022年02月18日 11:11:00
 */
public class TestDemo {
    public static void main(String[] args) {
        //这里对JDK动态代理进行分析

        SaleCarBeiJin target = new SaleCarBeiJin();
        ProxyHandler proxyHandler = new ProxyHandler(target);
        SaleCarAll saleCarAll =
                (SaleCarAll) proxyHandler.getProxy();
        saleCarAll.saleCar();
    }
}
