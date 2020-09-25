We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.

 

Example 1:

Input: [2,1,5]
Output: [5,5,0]
Example 2:

Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
Example 3:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]

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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2;
        int length = 0;
        while(temp1 != null){
            length++;
            temp1 = temp1.next;
        }
        int arr[] = new int[length];
        int index = 0;
        temp1 = head;
        while(temp1 != null){
            temp2 = temp1.next;
            boolean flag = false;
            while(temp2 != null){
                if(temp2.val > temp1.val){
                    flag = true;
                    arr[index] = temp2.val;
                    index++;
                    break;
                }
                temp2 = temp2.next;
            }
            if(!flag){
                arr[index] = 0;
                index++;
            }
            temp1 = temp1.next;
        }
        return arr;
    }
}
