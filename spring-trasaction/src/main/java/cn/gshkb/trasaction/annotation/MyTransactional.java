package cn.gshkb.trasaction.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
public @interface MyTransactional {

	boolean isStart() default false;

	boolean isEnd() default false;
}
