class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Store reserved seats for each row using a bitmask
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row=seat[0];
            int seatNum=seat[1];
            // Mark the reserved seat
            int mask=map.getOrDefault(row,0);
            mask |=(1 << (seatNum-1));
            map.put(row,mask);
        }
        // Every row can initially accommodate 2 families
        int result=2*n;
        for(int mask : map.values()) {
            // Remove the assumption of 2 families for this reserved row
            result-=2;
            // Check the three possible blocks
            boolean left=(mask & blockMask(2,5))==0;
            boolean middle=(mask & blockMask(4,7))==0;
            boolean right= (mask & blockMask(6,9))==0;
            if(left && right) {
                // Can place two families
                result+=2;
            } else if(left || middle || right) {
                // Can place one family
                result+=1;
            }
        }
        return result;
    }
    private int blockMask(int start,int end) {
        int mask=0;
        for(int i=start;i<=end;i++) {
            mask |= (1 << (i-1));
        }
        return mask;
    }
}
