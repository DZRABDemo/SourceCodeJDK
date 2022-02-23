package com.xufeifan.langStudy.PackageClass;

import org.junit.Test;

/**
 *  Class Function Analysis:
 *  抽象类Number是表示数字值可转换为基本数据类型平台类的超类
 *  byte ， double ， float ， int ， long和short 。
 *  从一个特定的数字值转换的特定语义Number实现给定的原语类型
 *  由定义Number所讨论的实现。
 *  对于平台类，转换往往是类似于一个基本收缩转换或加宽原语转换为
 *  The Java™ Language Specification限定用于原始类型之间的转换。
 *  因此，转换可能会丢失有关数值的总体大小的信息，可能会失去精度，
 *  甚至可能会返回与输入不同的符号结果。 有关转换的详细信息，
 *  请参阅给定的Number实现的文档。
 */
public class Info_Number {
    @Test
    public void testClassStructure(){
        //public abstract class Number implements java.io.Serializable{}
        //很显然 这是抽象类
        //这个类实现了Serializable接口
    }

    @Test
    public void testField(){
        //1.public abstract int intValue();
        //2.public abstract long longValue();
        //3.public abstract float floatValue();
        //4.public abstract float floatValue();
    }

    @Test
    public void testMethod(){
        /*
        *   1.public byte byteValue() {
                return (byte)intValue();
            }
            2.public short shortValue() {
                return (short)intValue();
            }
        */

        //这里和强制类型的转换有关
    }
}
