package cn.gshkb.data_structure.linked;

/**
 * 检查链表是否有环
 *
 * @author hkb
 * @create 2019-07-11 19:59 v1.0
 **/
public class Solution {

	public static boolean hasCycle(ListNode head) {

		ListNode fast = head;
		ListNode low = head;
		while (null != fast && null != fast.next && null != fast.next.next) {
			fast = fast.next.next;
			low  = low.next;
			if (fast.equals(low)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

   public static void main(String [] args){
	   ListNode listNode = new ListNode(1);
	   ListNode listNode1 = new ListNode(2);
	   ListNode listNode2 = new ListNode(3);
	   ListNode listNode3 = new ListNode(4);
	   ListNode listNode4 = new ListNode(5);
	   listNode.setNext(listNode1);
	   listNode1.setNext(listNode2);
	   listNode2.setNext(listNode);
	   listNode3.setNext(listNode);
	   listNode3.setNext(listNode);
	   System.out.println(hasCycle(listNode));
   }
}

class ListNode {
	int      val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}