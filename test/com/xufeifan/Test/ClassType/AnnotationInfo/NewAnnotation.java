package com.xufeifan.Test.ClassType.AnnotationInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author DZRABDemo
 * @version 1.0.0
 * @ClassName NewAnnotation
 * @Description TODO
 * @createTime 2022年02月18日 19:55:00
 */

/**
 * Target和ElementType有关
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NewAnnotation {
}
