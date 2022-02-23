package com.xufeifan.ProxyPattern.CglibProxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName UserInfo
 * @Description TODO
 * @createTime 2022年02月18日 15:58:00
 */
public class UserInfo {
    public void userAdd() {
        System.out.println("user add");
    }

    public void userDelete() {
        System.out.println("user delete");
    }

    public void userUpdate() {
        System.out.println("user update");
    }

    public void userShow() {
        System.out.println("user show");
    }
}
