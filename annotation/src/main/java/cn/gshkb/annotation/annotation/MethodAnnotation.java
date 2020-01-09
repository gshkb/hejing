package cn.gshkb.annotation.annotation;


import java.lang.annotation.*;
import java.util.Date;

/**
 * 用在function上的自定义注解
 *
 * @author hkb
 * @create 2019-08-22 14:47 v1.0
 **/
@Target(ElementType.METHOD)
@Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {

    public enum TypeEnum {ADD, INSERT, UPDATE, QUERY}

    ;

    public String name() default "";

    public TypeEnum type();

}
