class Solution { // 分治法
    private int countForConflict(int[] nums, int num, int lo , int hi){
        int count = 0;
        for (int i = lo; i <= hi; i++){ // 一定注意这里需要是小于等于
            if (num == nums[i]){
                count ++;
            }
        }
        return count;
    }

    private int divideAndConquer(int lo, int hi, int[] nums){
        if (lo == hi){
            return nums[lo];
        }
        int mid = lo + (hi - lo)/2;

        int leftResult = divideAndConquer(lo, mid, nums);
        int rightResult = divideAndConquer(mid + 1, hi, nums);

        if (leftResult == rightResult){
            return leftResult;
        }else{
            int leftcount = countForConflict(nums, leftResult, lo, hi);
            int rightcount = countForConflict(nums, rightResult, lo, hi);
            return leftcount > rightcount ? leftResult : rightResult;
        }
    }
    public int majorityElement(int[] nums) { 
        return divideAndConquer(0, nums.length - 1, nums);
    }
}