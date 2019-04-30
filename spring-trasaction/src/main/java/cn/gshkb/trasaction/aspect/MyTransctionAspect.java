package cn.gshkb.trasaction.aspect;

import cn.gshkb.trasaction.service.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

/**
 * @author hkb
 * @create 2019-04-30 17:02 v1.0
 **/
@Aspect
@Component
public class MyTransctionAspect implements Orders {

	@Around("@annotation(cn.gshkb.trasaction.annotation.MyTransactional)")
	public void around(ProceedingJoinPoint joinPoint){
		//多层切面的优先级的问题
			joinPoint.proceed();
	}
}
