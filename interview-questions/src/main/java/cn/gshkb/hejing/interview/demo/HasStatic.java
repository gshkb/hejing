package cn.gshkb.hejing.interview.demo;

/**
 * 面试题二
 * 静态变量
 * @author hkb
 * @create 2019-03-26 15:26 v1.0
 **/
public class HasStatic {

	private static int x = 100;

	public static void main(String args[]) {
		HasStatic hs1 = new HasStatic();
		hs1.x++;
		HasStatic hs2 = new HasStatic();
		hs2.x++;
		hs1 = new HasStatic();
		hs1.x++;
		HasStatic.x--;
		System.out.println("x=" + x);
	}
}
