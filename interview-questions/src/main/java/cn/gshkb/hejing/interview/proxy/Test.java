package cn.gshkb.hejing.interview.proxy;

/**
 * 测试类
 *
 * @author hkb
 * @create 2019-04-22 15:19 v1.0
 **/
public class Test {

    public static void main(String[] args) {
        IProxy iProxy = new Proxy(new Target());
        iProxy.execute();
    }
}
