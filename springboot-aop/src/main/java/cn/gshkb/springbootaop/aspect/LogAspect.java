package cn.gshkb.springbootaop.aspect;


import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

/**
 * 自定义切面
 *
 * @author hkb
 * @create 2019-04-23 11:30 v1.0
 **/


@Component
@Aspect
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(LogAspect.class);


    @Pointcut("execution(public * cn.gshkb.springbootaop.controller..*.*(..))")
    public void Pointcut() {
    }

    /**
     * 前置通知
     */
    @Before("Pointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("调用了前置通知");

    }

    /**
     * @param joinPoint
     * @After: 后置通知
     */
    @After("Pointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        log.info("调用了后置通知");
    }

    /**
     * @param joinPoint
     * @param result
     * @AfterRunning: 返回通知 rsult为返回内容
     */
    @AfterReturning(value = "Pointcut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        log.info("调用了返回通知");
    }

    /**
     * @param joinPoint
     * @param e
     * @AfterThrowing: 异常通知
     */
    @AfterThrowing(value = "Pointcut()", throwing = "e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e) {
        log.info("调用了异常通知");
    }

    /**
     * @param pjp
     * @return
     * @throws Throwable
     * @Around：环绕通知
     */
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around执行方法之前");
        Object object = pjp.proceed();
        log.info("around执行方法之后--返回值：" + object);
        return object;
    }

}
