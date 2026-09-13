class Solution {
    public int[] constructRectangle(int area) {
        // Start from sqrt(area) because
        // we want L and W to be as close as possible.
        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        int length = area / width;
        return new int[]{length, width};
    }
}
