package com.xufeifan.ProxyPattern.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName ProxyHandler
 * @Description TODO
 * @createTime 2022年02月18日 11:15:00
 */
@SuppressWarnings(value = "all")
public class ProxyHandler implements InvocationHandler {
    private Object target;

    public ProxyHandler(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return  Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
        //这里需要提交参数
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Security.checkSafe();
        Object invoke = method.invoke(target, args);
        Security.checkSafe();
        return invoke;
    }
}
