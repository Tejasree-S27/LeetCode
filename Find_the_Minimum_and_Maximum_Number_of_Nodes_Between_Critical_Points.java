class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first=-1;
        int previousCritical=-1;
        int minDistance=Integer.MAX_VALUE;
        ListNode prev=head;
        ListNode curr=head.next;
        int position=1;
        while(curr!=null && curr.next!=null) {
            boolean isMaxima=curr.val>prev.val && curr.val>curr.next.val;
            boolean isMinima=curr.val<prev.val && curr.val<curr.next.val;
            if(isMaxima || isMinima) {  
                if(first==-1) {
                    first=position;
                } else {
                    minDistance=Math.min(minDistance,position-previousCritical);
                }
                previousCritical=position;
            }
            prev=curr;
            curr=curr.next;
            position++;
        }
        if(first==-1 || first==previousCritical) {
            return new int[]{-1,-1};
        }
        return new int[]{minDistance,previousCritical-first};
    }
}
