/*Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL*/
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
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        ListNode fakenode = new ListNode();
        fakenode.next = head;
        int length = 0;
        while( head != null ){
            length++;
            head = head.next;
        }
        ListNode newNode = new ListNode();
        ListNode fakeNew = new ListNode();
        fakeNew.next = newNode;
        int curLength = length;
        for(int i = 0 ; i < length ; i++ ){
            curLength = curLength - 1;
            head = fakenode.next;
            for( int j = 0 ; j < curLength ; j++ ){
                head = head.next;
            }
            newNode.val = head.val;
            if(i == length - 1){
                break;
            }
            newNode.next = new ListNode();
            newNode = newNode.next;
        }
        return fakeNew.next;
    }
}
