package cn.gshkb.annotation.annotation;

import java.lang.annotation.*;

/**
 * 用在实体类属性上的自定义注解
 *
 * @author hkb
 * @create 2019-08-22 14:49 v1.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PropertyAnnotation {

    public String value() default "";

    public int sort() default 0;

    public String name() default "";
}

