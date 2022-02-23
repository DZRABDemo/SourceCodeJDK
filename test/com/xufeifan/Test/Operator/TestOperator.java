package com.xufeifan.Test.Operator;

import org.junit.Test;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName TestOperator
 * @Description TODO
 * @createTime 2022年02月18日 19:20:00
 */
@SuppressWarnings(value = "all")
public class TestOperator {
    @Test
    public void test01(){
        //expression1 ? expression2 : expression3
        System.out.println(1>0?(1>2?20:10):0);
        //三元运算符可以参与复合
    }
}
