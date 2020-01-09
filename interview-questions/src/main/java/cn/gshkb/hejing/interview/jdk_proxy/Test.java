package cn.gshkb.hejing.interview.jdk_proxy;

import java.lang.reflect.*;

/**
 * 测试jdk代理
 *
 * @author hkb
 * @create 2019-04-22 16:48 v1.0
 **/
public class Test {

    public static void main(String[] args) {
        Hello hello = (Hello) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), // 1. 类加载器
                new Class<?>[]{Hello.class}, //2. 代理需要实现的接口，可以有多个
                new HelloJdkProxy(new HelloTarget())); // 3. 方法调用的实际处理者(被代理者)
        System.out.println(hello.sayHello(" say hello"));

    }
}
