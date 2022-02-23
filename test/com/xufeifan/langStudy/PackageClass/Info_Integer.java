package com.xufeifan.langStudy.PackageClass;

import org.junit.Test;

/**
 * Class Function Analysis:
 * Integer类包装一个对象中的原始类型int的值。
 * 类型为Integer的对象包含一个单一字段，其类型为int 。
 * 此外，该类还提供了一些将int转换为String和String转换为int ，
 * 以及在处理int时有用的其他常量和方法。
 */

@SuppressWarnings(value = "all")
public class Info_Integer {
    @Test
    public void testClassStructure(){
        //public final class Integer extends Number implements Comparable<Integer>{}
        //这里继承了Number类 实现了内部比较器接口
    }

    @Test
    public void testBlock(){
        System.out.println("this class has not Block structure");
    }

    @Test
    public void testConstruction(){
        //这里存在两个构造方法
        /*
        * 1.public Integer(int value) {
                this.value = value;
            }
            这里用整型数值进行初始化
        */
        Integer integer1 = new Integer(10);

        /*
        * 2.public Integer(String s) throws NumberFormatException {
                this.value = parseInt(s, 10);
            }
        这里对字符串类型进行了解析 这里是10进制解析
        */

        Integer integer2 = new Integer("10");
    }

    public void testField(){

    }

    public void testMethod(){

    }

}
