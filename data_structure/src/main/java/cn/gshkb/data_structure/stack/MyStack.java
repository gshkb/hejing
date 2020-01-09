package cn.gshkb.data_structure.stack;

import cn.gshkb.data_structure.node.*;

import java.util.*;

/**
 * 简易栈
 *
 * @author hkb
 * @create 2019-07-10 10:47 v1.0
 **/
// "static void main" must be defined in a public class.
class MyStack {
    private List<Integer> data;               // store elements

    public MyStack() {
        data = new ArrayList<>();
    }

    /**
     * Insert an element into the stack.
     */
    public void push(int x) {
        data.add(x);
    }

    /**
     * Checks whether the queue is empty or not.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Get the top item from the queue.
     */
    public int top() {
        return data.get(data.size() - 1);
    }

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }

    public static void main(String[] args) {
		/*MyStack s = new MyStack();
		s.push(1);
		s.push(2);
		s.push(3);
		for (int i = 0; i < 4; ++i) {
			if (!s.isEmpty()) {
				System.out.println(s.top());
			}
			System.out.println(s.pop());
		}*/
        /**
         *         0
         *      /     \
         *      1     2
         *      / \  / \
         *     3  4  5  6
         */
        Node root = new Node(0);
        Node left = new Node(1);
        Node right = new Node(2);
        Node leftL = new Node(3);
        Node leftR = new Node(4);
        Node rightL = new Node(5);
        Node rightR = new Node(6);


        left.setRight(leftR);
        left.setLeft(leftL);
        right.setLeft(rightL);
        right.setRight(rightR);
        root.setLeft(left);
        root.setRight(right);
        //递归前序遍历
        preTraversal(root);
        System.out.printf("============");
        //递归中序遍历
        midTraversal(root);
        System.out.printf("============");
        //递归后序遍历
        postTraversal(root);
    }

    /**
     * 递归前序遍历
     * <p>
     * 前序遍历过程：
     * （1）访问根节点；
     * （2）采用先序递归遍历左子树；
     * （3）采用先序递归遍历右子树；
     * </p>
     *
     * @param node
     */
    public static void preTraversal(Node node) {
        //很重要，必须加上 当遇到叶子节点用来停止向下遍历
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preTraversal(node.getLeft());
        preTraversal(node.getRight());
    }

    /**
     * 递归中序遍历
     * <p>
     * （1）采用中序遍历左子树；
     * （2）访问根节点；
     * （3）采用中序遍历右子树
     * </p>
     *
     * @param node
     */
    public static void midTraversal(Node node) {
        if (node == null) {
            return;
        }
        midTraversal(node.getLeft());
        System.out.print(node.getValue() + " ");
        midTraversal(node.getRight());
    }

    /**
     * 递归后序遍历
     * <p>
     * （1）采用后序递归遍历左子树；
     * （2）采用后序递归遍历右子树；
     * （3）访问根节点；
     * </p>
     *
     * @param node
     */
    public static void postTraversal(Node node) {
        if (node == null) {
            return;
        }
        postTraversal(node.getLeft());
        postTraversal(node.getRight());
        System.out.print(node.getValue() + " ");
    }


}
