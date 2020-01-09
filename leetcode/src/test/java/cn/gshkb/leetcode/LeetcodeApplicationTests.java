package cn.gshkb.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetcodeApplicationTests {

    @Test
    public void contextLoads() {


    }

    @Test
    public void testDemo1() {
        Demo1 d = new Demo1();
        int[] a = new int[]{3, 2, 4};
		/*a[0] = 3;
		a[1] = 2;
		a[2] = 4;*/
        //a[3] = 4;
        //a[4] = 5;
        //int[] ints = d.twoSum(a, 6);
        int[] ints = d.twoSum1(a, 6);
        System.out.println(ints.toString());
    }
}
