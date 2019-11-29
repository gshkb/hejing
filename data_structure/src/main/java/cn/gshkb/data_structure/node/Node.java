package cn.gshkb.data_structure.node;

import java.util.*;

/**
 * node结构
 *
 * @author hkb
 * @create 2019-07-10 11:30 v1.0
 **/
public class Node<T> {
	/**
	 * 节点的值
	 */
	private T  value;
	/**
	 * 此节点，数据类型为Node
	 */
	private Node node;
	/**
	 * 此节点的左子节点，数据类型为Node
	 */
	private Node left;
	/**
	 * 此节点的右子节点，数据类型为Node
	 */
	private Node right;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {         //自定义的toString方法，为了方便之后的输出
		return this.value+"";
	}

	public static void create(int[] datas, List<Node> list) {

		//将数组里面的东西变成节点的形式
		for (int i = 0; i < datas.length; i++) {
			Node node = new Node(datas[i]);
			list.add(node);
		}

		//节点关联成树
		for (int index = 0; index < list.size() / 2 - 1; index++) {
			list.get(index).setLeft(list.get(index * 2 + 1));
			//编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
			list.get(index).setRight(list.get(index * 2 + 2));  //与上同理
		}

		//单独处理最后一个父节点 ,list.size()/2-1进行设置，避免单孩子情况
		int index = list.size() / 2 - 1;
		list.get(index).setLeft(list.get(index * 2 + 1));
		if (list.size() % 2 == 1) {
			//如果有奇数个节点，最后一个父节点才有右子节点
			list.get(index).setRight(list.get(index * 2 + 2));
		}
	}

}
