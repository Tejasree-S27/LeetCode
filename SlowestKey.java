class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime=releaseTimes[0];
        char ans=keysPressed.charAt(0);
        for(int i=1;i<releaseTimes.length;i++) {
            int duration=releaseTimes[i]-releaseTimes[i-1];
            if(duration>maxTime || (duration==maxTime && keysPressed.charAt(i)>ans)) {
                maxTime=duration;
                ans=keysPressed.charAt(i);
            }
        }
        return ans;
    }
}
