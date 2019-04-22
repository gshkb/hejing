package cn.gshkb.hejing.interview.cglib_proxy;


import net.sf.cglib.proxy.*;
import org.springframework.aop.framework.*;

/**
 * 测试cglib动态代理对象
 *
 * @author hkb
 * @create 2019-04-22 17:20 v1.0
 **/
public class Test {

	public static void main(String[] args) {
		HelloConcrete hello      = new HelloConcrete();
		MythodInterceptor  cglibProxy = new MythodInterceptor();
		HelloConcrete         proxy      = (HelloConcrete) cglibProxy.createProxy(hello);
		String        result     =proxy.sayHello("  cglib say hello");
		System.out.println(result);

	}
}
