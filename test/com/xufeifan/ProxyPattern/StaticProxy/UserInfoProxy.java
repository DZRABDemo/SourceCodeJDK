package com.xufeifan.ProxyPattern.StaticProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName UserInfoProxy
 * @Description TODO
 * @createTime 2022年02月18日 10:54:00
 */
public class UserInfoProxy {
    private UserInfo userInfo;

    {
        userInfo = new UserInfoImpl();
    }

    public static void proxy(){
        System.out.println("this is proxy method");
    }

    public void proxyUserAdd(){
        proxy();
        userInfo.userAdd();
    }

    public void proxyUserDelete(){
        proxy();
        userInfo.userDelete();
    }

    public void proxyUserUpdate(){
        proxy();
        userInfo.userUpdate();
    }

    public void proxyUserShow(){
        proxy();
        userInfo.userShow();
    }
}
