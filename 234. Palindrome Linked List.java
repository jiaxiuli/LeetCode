Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true

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
    public boolean isPalindrome(ListNode head) {
        ListNode fakehead = new ListNode();
        fakehead.next = head;
        int length = 0;
        while( head != null ){
            length++;
            head = head.next;
        }
        String s1 = "";
        String s2 = "";
        head = fakehead.next;
        for(int i = 0 ; i < length/2 ; i++ ){
            s1 = s1 + head.val;
            head = head.next;
        }
        if(length % 2 == 1)head = head.next;
        for(int i = 0 ; i < length/2 ; i++){
            s2 = head.val + s2;
            head = head.next;
        }
        return s1.equals(s2);
    }
}
