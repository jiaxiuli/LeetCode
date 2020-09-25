Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)return null;
        ListNode newHead = new ListNode();
        ListNode fakeHead = new ListNode();
        fakeHead = newHead;
        while(head != null){
            if(head.val != val){
                ListNode temp = new ListNode(head.val);
                newHead.next = temp;
                newHead = newHead.next;
                head = head.next;
            }else{
                head = head.next;
            }
        }
        return fakeHead.next;
       
    }
}
