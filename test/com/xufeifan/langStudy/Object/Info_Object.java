package com.xufeifan.langStudy.Object;

import org.junit.Test;

import java.util.Objects;

/**
 * Class function analysis:
 * Object类是所有类的超类
 * 这个类里面由常用的必须方法
 */
public class Info_Object {

    @Test
    public void testClassStructure() {
        /*
         * public class Object{}
         */
    }

    @Test
    public void testBlock() {
        /*
          static {
              registerNatives();
          }
        */
    }

    @Test
    public void testConstruction() {
        System.out.println("这个类仅仅只有默认的构造方法");
    }

    @Test
    public void testField() {
        System.out.println("This class has no constructor");
    }

    @Test
    public void testMethod() {

        //1.public final native Class<?> getClass();
        //testGetClass();

        //2.public native int hashCode();
        //testHashCode();

        /*3.public boolean equals(Object obj) {
                return (this == obj);
            }
        */
        //testEquals();

        /*
        *4.public String toString() {
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
            }
        */
        //testToString();

        //5.protected native Object clone() throws CloneNotSupportedException;
        // testClone();

        //6.protected void finalize() throws Throwable {}
        //testFinalize();

        //7.public final native void wait(long timeout) throws InterruptedException;

        //8.public final native void notify();

        /*
        * 这里不对wait和notify多做研究
        * wait方法让当前对象的拥有线程进行等待池
        * notify唤醒对象等待池中的线程
        */

    }

    public static void testHashCode(){
        Object_Template object_template =
                new Object_Template();
        System.out.println(object_template.hashCode());
        //1347137144
    }

    public static void testEquals(){
        Object_Template object_template1 =
                new Object_Template("张三", 20);

        Object_Template object_template2 =
                new Object_Template("张三",20);

        System.out.println(object_template1.equals(object_template2));
    }

    public static void testToString(){
        Object_Template object_template =
                new Object_Template("张三", 20);

        System.out.println(object_template.toString());
    }

    public static void testGetClass() {
        Object_Template object_template1 =
                new Object_Template();

        Object_Template object_template2 =
                new Object_Template();

        Class<? extends Object_Template> aClass1 =
                object_template1.getClass();
        Class<? extends Object_Template> aClass2 =
                object_template1.getClass();

        System.out.println(aClass1);
        System.out.println(aClass2);
    }

    public static void testClone(){
        //这里分为浅拷贝和深拷贝
        //浅拷贝和深拷贝的区别在于引用类型的对象
        //浅拷贝引用类型的地址相同
        //深拷贝是创建新的对象
        Object object = new Object();
        Object_Template object_template =
                new Object_Template("张三", 20, object);
        try {
            Object_Template clone =
                    (Object_Template) object_template.clone();

            System.out.println(System.identityHashCode(object_template.getObject()));
            System.out.println(System.identityHashCode(clone.getObject()));
            //1347137144
            //1347137144
            //这里引用相同 很显然默认是浅拷贝
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void testFinalize(){
        //这里对垃圾回收进行分析
        try {
            FinalizeEscapeGC.testMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Object_Template implements Cloneable{
    private String name;
    private int age;
    private Object object;

    public Object_Template() {
    }

    public Object_Template(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Object_Template(String name, int age, Object object) {
        this.name = name;
        this.age = age;
        this.object = object;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //首先对对象的哈希值进行分析
        if (o == null || getClass() != o.getClass()) return false;
        //对字节码对象进行比较
        Object_Template that = (Object_Template) o;
        return age == that.age &&
                Objects.equals(name, that.name);
        //比较对象的属性值
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
        //这里利用属性值获得哈希值
    }

    @Override
    public String toString() {
        return "Object_Template{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        System.out.println(this);
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void testMain() throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive(); }
        else {
            System.out.println("no, i am dead :("); }
        // 下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
