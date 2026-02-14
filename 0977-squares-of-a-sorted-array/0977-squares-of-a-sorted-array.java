class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] numSquare = new int[n];
        for (int i = 0; i < n; i++) {
            numSquare[i] = nums[i] * nums[i];
        }
        Arrays.sort(numSquare);
        return numSquare;
    }
}