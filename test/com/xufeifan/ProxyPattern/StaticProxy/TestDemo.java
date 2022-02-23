package com.xufeifan.ProxyPattern.StaticProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestDemo
 * @Description TODO
 * @createTime 2022年02月18日 11:05:00
 */
public class TestDemo {
    public static void main(String[] args) {
        UserInfoProxy userInfoProxy = new UserInfoProxy();

        userInfoProxy.proxyUserAdd();

        userInfoProxy.proxyUserDelete();

        userInfoProxy.proxyUserUpdate();

        userInfoProxy.proxyUserShow();

        /*
            this is proxy method
            user add
            this is proxy method
            user delete
            this is proxy method
            user update
            this is proxy method
            user show
            Process finished with exit code 0
        */
    }
}
