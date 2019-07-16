package cn.gshkb.data_structure.hash;

import java.util.*;

/**
 * 设计一个hash集合
 *
 * @author hkb
 * @create 2019-07-13 14:16 v1.0
 **/
public class MyHashSet {

	private List<LinkedList<Integer>> bucket;

	private int initSize = 15;

	private int size = 0;

	private int addSize = 10;

	/**
	 * Initialize your data structure here.
	 */

	public MyHashSet() {
		bucket = new ArrayList<LinkedList<Integer>>();
		for (int i = 0; i < initSize; i++) {
			bucket.add(new LinkedList<Integer>());
		}
		size = initSize;
	}

	public void add(int key) {
		if (!contains(key)) {
			if (bucket.size() <= initSize * 0.8) {
				for (int i = 0; i < addSize; i++) {
					bucket.add(new LinkedList<Integer>());
				}
				size = size + addSize;
			}
			bucket.get(key % size).add(key);
		}
	}

	public void remove(int key) {
		if (contains(key)) {
			bucket.get(key % size).removeFirstOccurrence(key);
		}
	}

	/**
	 * Returns true if this set contains the specified element
	 */
	public boolean contains(int key) {
		LinkedList<Integer> linkedList = bucket.get(key % size);
		for (Integer i : linkedList) {
			if (i == key) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add(1);
		myHashSet.add(2);
		System.out.println(myHashSet.contains(1));
		System.out.println(myHashSet.contains(2));
		myHashSet.add(2);
		myHashSet.remove(2);
		System.out.println(myHashSet.contains(2));


	}
}
