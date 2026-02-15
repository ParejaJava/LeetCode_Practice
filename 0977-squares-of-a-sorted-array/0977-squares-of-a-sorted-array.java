class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] numSquare = new int[n];
        int i = 0;
        while (i < n && nums[i] < 0) {
            i++;
        }
        int neg = i - 1;
        int p = i; // p == pos
        int idx = 0;
        while (neg >= 0 || p < n) {
            if (neg < 0) {
                numSquare[idx] = nums[p] * nums[p];
                p++;
                idx++; //记得维护所有指针
                continue; //忘了
            }
            if (p > n - 1) {
                numSquare[idx] = nums[neg] * nums[neg];
                neg--;
                idx++;
                continue; //忘了
            }
            if (nums[neg] * nums[neg] < nums[p] * nums[p]) {
                numSquare[idx] = nums[neg] * nums[neg];
                idx++;
                neg--;
            }else {
                numSquare[idx] = nums[p] * nums[p];
                idx++;
                p++;
            }
        }
        return numSquare;
    }
}