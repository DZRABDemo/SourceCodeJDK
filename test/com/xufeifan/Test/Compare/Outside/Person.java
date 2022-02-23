package com.xufeifan.Test.Compare.Outside;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName Person
 * @Description TODO
 * @createTime 2022年02月18日 19:33:00
 */
@SuppressWarnings(value = "all")
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
