package com.xufeifan.Test.Compare.Inside;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestDemo
 * @Description TODO
 * @createTime 2022年02月18日 19:05:00
 */
@SuppressWarnings(value = "all")
public class TestDemo {
    public static void main(String[] args) {
        //这里对内部比较器进行分析 比较器主要用于集合

        //首先创建集合
        ArrayList<Person> arrayList = new ArrayList<>();

        arrayList.add(new Person("王五",50));
        arrayList.add(new Person("张三",30));
        arrayList.add(new Person("李四",40));

        Collections.sort(arrayList);

        for (Person person:
             arrayList) {
            System.out.println(person);
        }
    }
}
