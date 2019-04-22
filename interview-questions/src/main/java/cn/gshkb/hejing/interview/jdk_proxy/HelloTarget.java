package cn.gshkb.hejing.interview.jdk_proxy;

/**
 * 被代理目标对象
 *
 * @author hkb
 * @create 2019-04-22 16:35 v1.0
 **/
public class HelloTarget implements Hello{

	@Override
	public String sayHello(String str) {
		return "HelloTarget"+str;
	}
}
