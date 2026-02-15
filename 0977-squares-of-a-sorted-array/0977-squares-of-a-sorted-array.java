class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] numSquare = new int[n];
        int l = 0;
        int r = n - 1;
        int idx = n - 1;
        while(l <= r) {
            int lSquare = nums[l] * nums[l];
            int rSquare = nums[r] * nums[r];
            if (lSquare < rSquare) {
                numSquare[idx] = rSquare;
                r--;
            } else {
                numSquare[idx] = lSquare;
                l++;
            }
            idx--;
        }
        return numSquare;
    }
}