package cn.gshkb.data_structure.queue;

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
	/*	MyQueue q = new MyQueue();
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
		}*/

		// 1. Initialize a queue.
		/*Queue<Integer> q = new LinkedList();
		// 2. Get the first element - return null if queue is empty.
		System.out.println("The first element is: " + q.peek());
		// 3. Push new element.
		q.offer(5);
		q.offer(13);
		q.offer(8);
		q.offer(6);
		// 4. Pop an element.
		*//*Integer poll = q.poll();
		System.out.println("poll是: "+poll);
		Integer poll2 = q.poll();
		System.out.println("poll是: "+poll2);
		Integer poll3 = q.poll();
		System.out.println("poll是: "+poll3);
		Integer poll4 = q.poll();
		System.out.println("poll是: "+poll4);*//*
		while (!q.isEmpty()){
			System.out.println(q.poll());
		}
		// 5. Get the first element.
		System.out.println("The first element is: " + q.peek());
		// 7. Get the size of the queue.
		System.out.println("The size is: " + q.size());*/
		for (int i = 0;i<99;i++){
			System.out.println(i%99);
		}
	}



}




