package cn.gshkb.hejing.interview.demo;

/**
 * 面试题三
 * 解析: 0可以是除数.所以不会抛出异常
 * 0不可以是被除数,所以会抛出异常
 *
 * @author hkb
 * @create 2019-03-26 15:32 v1.0
 **/
public class Test {

    public static int aMethod(int i) throws Exception {
        try {
            return i / 10;
        } catch (Exception ex) {
            throw new Exception("exception in a Method");
        } finally {
            System.out.printf("finally");
        }
    }

    public static int bMethod(int i) throws Exception {
        try {
            return 10 / i;
        } catch (Exception ex) {
            throw new Exception("exception in a Method");
        } finally {
            System.out.printf("finally");
        }
    }

    public static void main(String[] args) {
        try {
            aMethod(0);
            bMethod(0);
        } catch (Exception ex) {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
}
