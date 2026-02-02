class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(table.containsKey(target - nums[i])){
                return new int[]{i,table.get(target - nums[i])};
            }
            else{
                table.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}