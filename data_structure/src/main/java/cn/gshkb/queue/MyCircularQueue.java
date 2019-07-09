package cn.gshkb.queue;

import java.util.*;

/**
 * 设计一个循环队列
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hkb
 * @create 2019-07-09 14:15 v1.0
 **/
public class  MyCircularQueue<T> {

	private int[] datas;
    //数组长度临时变量
	private int length = 0;
	//存入指针
	private int fp = 0;
    //取出指针
	private int lp = 0;


	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
       this.datas = new int[k];
       this.length = k;
	}

	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if (isFull()){
			return false;
		}
            datas[fp] = value;
		    fp++;
		    length++;
		return true;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
       if (isEmpty()) {
			return false;
       }
       if (lp==datas.length-1){
       	    lp = 0;
       }
       lp++;
       return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if (isEmpty()){
			return -1;
		}
     return datas[fp];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if (isEmpty()){
			return -1;
		}
		return datas[lp];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		if (datas.length == 0){
			return true;
		}
      return false;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		if (datas.length==length){
			return true;
		}
		return false;
	}
}
