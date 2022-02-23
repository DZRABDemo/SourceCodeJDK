package com.xufeifan.Test.Compare.Outside;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestDemo
 * @Description TODO
 * @createTime 2022年02月18日 19:34:00
 */
@SuppressWarnings(value = "all")
public class TestDemo {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<Person>();

        arrayList.add(new Person("王五",50));
        arrayList.add(new Person("张三",30));
        arrayList.add(new Person("李四",40));

        Collections.sort(arrayList,new ComparatorAsc());

        for (Person person :
               arrayList ) {
            System.out.println(person);
        }

        Collections.sort(arrayList,new ComparatorDesc());

        for (Person person :
                arrayList ) {
            System.out.println(person);
        }
    }

}

class ComparatorAsc implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()- o2.getAge();
    }
}

class ComparatorDesc implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge()- o1.getAge();
    }
}
