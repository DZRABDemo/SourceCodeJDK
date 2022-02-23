package com.xufeifan.ProxyPattern.StaticProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName UserInfoImpl
 * @Description TODO
 * @createTime 2022年02月18日 10:52:00
 */
public class UserInfoImpl implements UserInfo{
    @Override
    public void userAdd() {
        System.out.println("user add");
    }

    @Override
    public void userDelete() {
        System.out.println("user delete");
    }

    @Override
    public void userUpdate() {
        System.out.println("user update");
    }

    @Override
    public void userShow() {
        System.out.println("user show");
    }
}
