package com.xufeifan.ProxyPattern.CglibProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestDemo
 * @Description TODO
 * @createTime 2022年02月18日 16:15:00
 */
public class TestDemo {
    public static void main(String[] args) {
        UserInfo target = new UserInfo();
        ProxyCglib proxyCglib =
                new ProxyCglib(target);
        UserInfo userinfo =(UserInfo) proxyCglib.getProxyInstance();
        userinfo.userAdd();
    }
}
