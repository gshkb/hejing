package cn.gshkb.queue;

import java.util.*;

/**
 * 模拟队列的结构
 * <p>
 * 代码copy自:
 * https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/863/
 * <p>
 * 队列:FIFO 先进先出
 * 取数据时:指针始终后移.
 * 缺陷:这种取数据时,必须判断队列是否为空,否则出现 IndexOutOfBoundsException
 * </p>
 *
 * @author hkb
 * @create 2019-07-09 10:16 v1.0
 **/
public class MyQueue {


	// store elements
	private List<Integer> data;
	// a pointer to indicate the start position
	private int           p_start;

	public MyQueue() {
		data = new ArrayList<Integer>();
		p_start = 0;
	}

	/**
	 * Insert an element into the queue. Return true if the operation is successful.
	 */
	public boolean enQueue(int x) {
		data.add(x);
		return true;
	}


	/**
	 * Delete an element from the queue. Return true if the operation is successful.
	 */
	public boolean deQueue() {
		if (isEmpty() == true) {
			return false;
		}
		p_start++;
		return true;
	}

	/**
	 * Get the front item from the queue.
	 */
	public int Front() {
		return data.get(p_start);
	}

	/**
	 * Checks whether the queue is empty or not.
	 */
	public boolean isEmpty() {
		return p_start >= data.size();
	}


	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.enQueue(5);
		q.enQueue(4);
		q.enQueue(3);
		q.enQueue(2);
		q.enQueue(1);
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (q.isEmpty() == false) {
			System.out.println(q.Front());
		}

	}

}




