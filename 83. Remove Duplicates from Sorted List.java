/*Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3*/

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakehead = new ListNode();
        ListNode fakehead0 = new ListNode();
        fakehead.next = head;
        fakehead0.next = head;
        while(fakehead.next != null){
            if(fakehead.next.val != head.val){
                head.next = fakehead.next;
                head = head.next;
            }else{
                fakehead.next = fakehead.next.next;
                if(fakehead.next == null){
                    head.next = null;
                }
            }
            
        }
        return fakehead0.next;
    }
}
