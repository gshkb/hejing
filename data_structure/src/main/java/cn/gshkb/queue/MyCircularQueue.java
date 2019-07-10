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

	private int[] data;
	private int head;
	private int tail;
	private int size;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		data = new int[k];
		head = -1;
		tail = -1;
		size = k;
	}

	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if (isFull() == true) {
			return false;
		}
		if (isEmpty() == true) {
			head = 0;
		}
		tail = (tail + 1) % size;
		data[tail] = value;
		return true;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if (isEmpty() == true) {
			return false;
		}
		if (head == tail) {
			head = -1;
			tail = -1;
			return true;
		}
		head = (head + 1) % size;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if (isEmpty() == true) {
			return -1;
		}
		return data[head];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if (isEmpty() == true) {
			return -1;
		}
		return data[tail];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return head == -1;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return ((tail + 1) % size) == head;
	}
}
