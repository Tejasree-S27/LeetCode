public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start=1;
        int end=n;
        while (start<=end) {
            // Calculate middle (avoids overflow)
            int mid=start+(end-start)/2;
            // Get feedback from the guess API
            int result=guess(mid);
            if (result==0) 
            {
                return mid;  // Correct guess!
            } else if (result==-1) 
            {
                // Guess is too high, search lower
                end=mid-1;
            } else {
                // Guess is too low, search higher
                start=mid+1;
            }
        }
        return start;
    }
}
