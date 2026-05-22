class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 我现在要写一个前后缀的代码，pre[i]代表nums[0, i-1]的乘积，
        // 然后suf[i]代表nums[i+1, n-1]的乘积
        // 定义完成再写，看看效果怎么样
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }
        suf[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }
}