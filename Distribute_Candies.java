class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>();
        for (int candy : candyType) {
            types.add(candy);
        }
        return Math.min(types.size(), candyType.length / 2);
    }
}
