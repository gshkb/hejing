package cn.gshkb.data_structure.hash;

import java.util.*;

/**
 * hash映射
 *
 * @author hkb
 * @create 2019-07-13 15:28 v1.0
 **/
public class MyHashMap {


	private List<Node> bucket;


	/**
	 * Initialize your data structure here.
	 */
	public MyHashMap() {
		bucket = new ArrayList<Node>();
	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		if (get(key) != -1) {
			bucket.remove(getNode(key));
		}
		Node node = new Node(key);
		node.put(value);
		bucket.add(node);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		if (bucket.size() > 0) {
			for (Node node : bucket) {
				if (node.getKey() == key) {
					return 	node.getBuckets().getLast();
				}
			}
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key) {
		if (bucket.size() > 0) {
			for (Node node : bucket) {
				if (node.equals(getNode(key))) {
					bucket.remove(node);
					return;
				}
			}
		}
	}

	public Node getNode(int key) {
		if (bucket.size() > 0) {
			for (Node node : bucket) {
				if (node.getKey() == key) {
					return 	node;
				}
			}
		}
		return null;
	}
}

class Node {

	private Integer key;

	private LinkedList<Integer> buckets ;

	private int index;

	public Node() {
		index = 0;
		buckets = new LinkedList<>();
	}

	public Node(Integer key) {
		index = 0;
		buckets = new LinkedList<>();
		this.key = key;
	}

	public Integer getKey() {
		return key;
	}

	public void put(int value) {
		buckets.addLast(value);
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public LinkedList<Integer> getBuckets() {
		return buckets;
	}

	public void setBuckets(LinkedList<Integer> buckets) {
		this.buckets = buckets;
	}


}

