package com.xufeifan.Test.Compare.Inside;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName Person
 * @Description TODO
 * @createTime 2022年02月18日 19:03:00
 */
@SuppressWarnings(value = "all")
public class Person implements Comparable<Person>{
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

    @Override
    public int compareTo(Person person) {
        return this.age-person.age;
    }
}
