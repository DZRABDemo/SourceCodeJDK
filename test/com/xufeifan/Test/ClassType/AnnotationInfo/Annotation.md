```
1.@Target,这里说明了注解对那些元素进行修饰
2.@Retention,
这里说明自定义注解的保留时间
    1.SOURCE 源码
    2.Class 编译器
    3.Runtime 运行
3.@Documented,
生成的文档是否有此注释
4.@Inherited
子类是否会继承此类的注释

常见的注解有:
@Override
这是用于重写的标志位
@SuppressWarning
这里可以抑制警告
```

**参考代码**
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test{}
```
这里我们使用了@interface声明了Test注解

并且使用了@Target注解传入ElementType.METHOD参数

这个参数表明了这个注解只能使用在方法上面

@Retention(RetentionPolicy.RUNTIME)

这里说明了注解的生存期是运行时

```java
package java.lang.annotation;

public enum ElementType {
    /** Class, interface (including annotation type), or enum declaration */
    TYPE,

    /** Field declaration (includes enum constants) */
    FIELD,

    /** Method declaration */
    METHOD,

    /** Formal parameter declaration */
    PARAMETER,

    /** Constructor declaration */
    CONSTRUCTOR,

    /** Local variable declaration */
    LOCAL_VARIABLE,

    /** Annotation type declaration */
    ANNOTATION_TYPE,

    /** Package declaration */
    PACKAGE,

    /**
     * Type parameter declaration
     *
     * @since 1.8
     */
    TYPE_PARAMETER,

    /**
     * Use of a type
     *
     * @since 1.8
     */
    TYPE_USE
}

```

```java
package java.lang.annotation;

public enum RetentionPolicy {
    /**
     * Annotations are to be discarded by the compiler.
     */
    SOURCE,

    /**
     * Annotations are to be recorded in the class file by the compiler
     * but need not be retained by the VM at run time.  This is the default
     * behavior.
     */
    CLASS,

    /**
     * Annotations are to be recorded in the class file by the compiler and
     * retained by the VM at run time, so they may be read reflectively.
     *
     * @see java.lang.reflect.AnnotatedElement
     */
    RUNTIME
}
```