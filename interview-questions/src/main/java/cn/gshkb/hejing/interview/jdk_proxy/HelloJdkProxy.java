package cn.gshkb.hejing.interview.jdk_proxy;

import java.lang.reflect.*;

/**
 * jdk代理
 *
 * @author hkb
 * @create 2019-04-22 16:37 v1.0
 **/
public class HelloJdkProxy implements InvocationHandler {

	private Hello hello;

	public HelloJdkProxy(HelloTarget helloTarget) {
		this.hello=helloTarget;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start invoke");
		if (method.getName().equals("sayHello")){
			System.out.println("start sayHello");
		}
		return method.invoke(hello,args);
	}

}
