class Solution {
    public int majorityElement(int[] nums) { // 排序法
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}