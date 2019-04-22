package cn.gshkb.hejing.interview.cglib_proxy;

import java.lang.reflect.*;
import net.sf.cglib.proxy.*;

/**
 * cg-lib动态代理
 *
 * @author hkb
 * @create 2019-04-22 17:15 v1.0
 **/
public class MythodInterceptor implements MethodInterceptor {

   private Object obj;

	public Object createProxy(Object target) {
		this.obj = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.obj.getClass());
		// 设置代理目标
		enhancer.setCallback(this);
		// 设置回调
		enhancer.setClassLoader(target.getClass().getClassLoader());
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("start intercept");
		System.out.println("intercept before");
		Object invoke = methodProxy.invokeSuper (o, objects);
		System.out.println("intercept after");
		return invoke;
	}


}
