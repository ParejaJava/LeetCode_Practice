class Solution {
    public int maxSubArray(int[] nums) {
        int[] s = new int[nums.length + 1];
        s[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            s[i+1] = s[i] + nums[i];
        }
        int ans = Integer.MIN_VALUE;
        int minSum = s[0];
        for (int sum = 1; sum < nums.length + 1; sum++){
            ans = Math.max(ans, s[sum] - minSum);
            minSum = Math.min(minSum, s[sum]);
        }
        return ans;
    }
}