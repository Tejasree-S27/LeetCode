class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        // Find the middle
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        // For odd length, skip the middle node
        if(fast!=null) {
            slow=slow.next;
        }
        // Reverse the second half
        ListNode secondHalf=reverse(slow);
        ListNode firstHalf=head;
        // Compare both halves
        while(secondHalf!=null) {
            if(firstHalf.val!=secondHalf.val) {
                return false;
            }
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev=null;
        while(head!=null) {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
