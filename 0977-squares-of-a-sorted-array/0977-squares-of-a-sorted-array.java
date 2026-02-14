class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] numSquare = new int[n];
        int i = 0;
        while (i < n && nums[i] < 0) {
            i++;
        }
        if (i == 0) {
            for (int a = 0; a < n; a++) {
                numSquare[a] = nums[a] * nums[a];
            }
            return numSquare;
        }else if (i == n) {
            int j = n - 1; // 初始下标别越界
            for (int b = 0; b < n; b++) {
                numSquare[b] = nums[j] * nums[j];
                j--;
            }
            return numSquare;
        }else {
            int neg = i - 1;
            int p = i; // p == pos
            int idx = 0;
            while (neg >= 0 || p < n) {
                if (neg < 0) {
                    numSquare[idx] = nums[p] * nums[p];
                    idx++; //记得维护所有指针
                    continue; //忘了
                }
                if (p > n - 1) {
                    numSquare[idx] = nums[neg] * nums[neg];
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
}