class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 这个题的关键是知道自己写的是闭区间，另一个关键是处理如何处理target不存在或者在端点
        // 这种边界条件
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[] {-1, -1};
        }
        int end = lowerBound(nums, target + 1) - 1;
        return new int[] {start, end};
    }
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // <=是闭区间的标志
        int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1; // R+1一定是蓝色
            } else {
                left = mid + 1; // L-1一定是红色，于是，当L=R+1循环结束时，这个值就是答案
            }
        }
        return left;
    }
}