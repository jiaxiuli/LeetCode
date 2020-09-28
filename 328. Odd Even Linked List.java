/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)return null;
        if(head.next == null)return head;
        ListNode fakehead = new ListNode();
        fakehead.next = head;
        ListNode pot1 = new ListNode();
		ListNode pot2 = new ListNode();
		ListNode pot3 = new ListNode();
		ListNode fixpot = new ListNode();
		
		pot1 = head;
		pot2 = pot1.next;
		fixpot = pot2;
		pot3 = pot2.next;
		int count = 3;
		while(pot2.next != null) {
			boolean flag = true;
			
			pot1.next = pot3;
			pot2.next = pot3.next;
			pot3.next = fixpot;
	
			
			pot2 = pot2.next;
			pot1 = pot1.next;
			for(int i = 0 ; i < count ; i++ ) {
				if(pot3 == null) {
					flag = false;
					break;
				}
				pot3 = pot3.next;
			}
			if(!flag)break;
			count++;
        }
		return fakehead.next;
    }
}
