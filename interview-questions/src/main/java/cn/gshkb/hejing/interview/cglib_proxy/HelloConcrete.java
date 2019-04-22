package cn.gshkb.hejing.interview.cglib_proxy;

/**
 * 没有实现任何接口的需要被实例化的对象
 *
 * @author hkb
 * @create 2019-04-22 17:12 v1.0
 **/
public class HelloConcrete {

	public String sayHello(String str) {
		return "HelloConcrete: " + str;
	}
}
