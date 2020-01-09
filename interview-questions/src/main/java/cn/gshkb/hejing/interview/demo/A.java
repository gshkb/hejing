package cn.gshkb.hejing.interview.demo;

/**
 * 代码题1
 *
 * @author hkb
 * @create 2019-03-26 14:39 v1.0
 **/
class A implements B {
    public static void main(String args[]) {
        int i;
        A a1 = new A();
        i = a1.k;
        System.out.println("i=" + i);
    }
}

interface B {
    int k = 10;

}