package cn.gshkb.trasaction.aspect;


import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

/**
 * @author hkb
 * @create 2019-04-30 17:02 v1.0
 **/
@Aspect
@Component
public class MyTransctionAspect /**implements Orders**/
{

    //@Around("@annotation(cn.gshkb.trasaction.MyTransactional)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        //多层切面的优先级的问题
        joinPoint.proceed();
    }

    //@Override
    public int getOrder() {
        return 0;
    }
}
