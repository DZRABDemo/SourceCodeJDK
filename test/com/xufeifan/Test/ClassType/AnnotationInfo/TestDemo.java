package com.xufeifan.Test.ClassType.AnnotationInfo;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestDemo
 * @Description TODO
 * @createTime 2022年02月19日 10:15:00
 */
public class TestDemo {
    @Test
    public void simpleUse(){
        Person person = new Person();

        Class<? extends Person> aClass = person.getClass();

        AnnotatedType[] annotatedInterfaces = aClass.getAnnotatedInterfaces();


    }
}
