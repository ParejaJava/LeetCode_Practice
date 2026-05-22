class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] sf = new int[nums.length];
        int[] sb = new int[nums.length];
        sf[0] = 1;
        sb[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            sf[i + 1] = sf[i] * nums[i]; 
        }
        for (int j = 0; j < nums.length - 1; j++) {
            sb[j + 1] = sb[j] * nums[nums.length - 1 - j];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = sf[i] * sb[nums.length - i - 1];
        }
        return ans;
    }
}