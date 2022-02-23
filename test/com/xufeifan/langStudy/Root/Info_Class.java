package com.xufeifan.langStudy.Root;

/**
 * Class Function Analysis:
 * Class类的类表示正在运行的Java应用程序中的类和接口。
 * 枚举是一种类，一个注释是一种界面。
 * 每个数组也属于一个反映为类对象的类，
 * 该对象由具有相同元素类型和维数的所有数组共享。
 * 原始Java类型（ boolean ， byte ， char ， short ， int ， long ， float和double ），
 * 和关键字void也表示为类对象。
 * 类没有公共构造函数。 相反， 类对象由Java虚拟机自动构建，
 * 因为加载了类，并且通过调用类加载器中的defineClass方法。
 */
public class Info_Class {
    public void testClassStructure(){
        /*
        * public final class Class<T> implements java.io.Serializable,
                              GenericDeclaration,
                              Type,
                              AnnotatedElement {}
        1.Serializable 序列化接口
        2.GenericDeclaration 声明类型变量的所有实体的通用接口。
        3.Type Type是Java编程语言中所有类型的通用超级接口
        4.表示当前在此VM中运行的程序的注释元素。 该界面允许反射读取注释。
        */
    }
}
