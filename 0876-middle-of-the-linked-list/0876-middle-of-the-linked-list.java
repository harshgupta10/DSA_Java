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
    public ListNode middleNode(ListNode head) {
        int count=0;
        ListNode node = head;
        while(node!=null){
            count++;
            node=node.next;
            
        }
        
        if(count/2!=0)count=(count/2)+1;
        else count=((int)count/2) +1;
        
        // System.out.println(count);
        
        ListNode node2 = head;
        while(node2!=null){
            count--;
            if(count==0){
                return node2;
            }
            node2=node2.next;
        }
        return null;
    }
}