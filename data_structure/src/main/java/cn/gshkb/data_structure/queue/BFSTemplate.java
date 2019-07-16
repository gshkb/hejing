package cn.gshkb.data_structure.queue;


import cn.gshkb.data_structure.node.*;

import java.util.*;
import java.util.concurrent.*;

/**
 * 广度优先搜索模板
 *
 * @author hkb
 * @create 2019-07-10 10:54 v1.0
 **/
public class BFSTemplate {

	/**
	 * Return the length of the shortest path between root and target node.
	 */
	int BFS1(Node root, Node target) {
		Queue<Node> queue = new ConcurrentLinkedQueue<>();  // store all nodes which are waiting to be processed
		int         step  = 0;       // number of steps neeeded from root to current node
		// initialize
		queue.add(root);
		// BFS
		while (!queue.isEmpty()) {
			step = step + 1;
			// iterate the nodes which are already in the queue
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Node cur = queue.peek();
				if (cur.equals(target)){
					return step;
				}
				if (cur.getLeft()!=null){
					queue.add(cur.getLeft());
				}
				if (cur.getRight()!=null){
					queue.add(cur.getRight());
				}
				queue.poll();
			}
		}
		return -1;          // there is no path from root to target
	}

	/**
	 * Return the length of the shortest path between root and target node.
	 */
	int BFS2(Node root, Node target) {
		// store all nodes which are waiting to be processed
		Queue<Node> queue = new ConcurrentLinkedQueue<>();
		// store all the used nodes
		Set<Node> used = new HashSet<>();
		// number of steps neeeded from root to current node
		int step = 0;
		// initialize
		// add root to queue;
		// add root to used;
		queue.add(root);
		used.add(root);
		// BFS
		while (!queue.isEmpty()) {
			step = step + 1;
			// iterate the nodes which are already in the queue
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Node cur = queue.peek();
				if (cur.equals(target)){
					return step;
				}
				if (cur.getLeft()!=null){
					queue.add(cur.getLeft());
					used.add(cur.getLeft());
				}
				if (cur.getRight()!=null){
					queue.add(cur.getRight());
					used.add(cur.getRight());
				}
				queue.poll();
			}
		}
		// there is no path from root to target
		return -1;
	}
}
