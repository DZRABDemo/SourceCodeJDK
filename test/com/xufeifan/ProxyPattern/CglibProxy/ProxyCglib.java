package com.xufeifan.ProxyPattern.CglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName ProxyCglib
 * @Description TODO
 * @createTime 2022年02月18日 16:01:00
 */
public class ProxyCglib implements MethodInterceptor {
    public Object target;

    public ProxyCglib(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Security.checkSafe();

        Object returnValue = method.invoke(target, objects);

        Security.checkSafe();

        return returnValue;
    }
}
