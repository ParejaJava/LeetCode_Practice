class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // 排序+双指针
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        int n = nums.length;
        for (int x = 0; x < n; x++){ // 增强for循环中，x是变量，切记
            if (nums[x] > 0){
                break;
            }
            if (x > 0 && nums[x - 1] == nums[x]){
                continue;
            }
            int z = n - 1;
            for(int y = x + 1; y < n; y++){
                if (y == z){
                    break;
                }
                if (y > x + 1 && nums[y] == nums[y - 1]){
                    continue;
                }
                if (z < n - 1 && nums[z] == nums[z + 1]){
                    z--;
                    y--;
                    continue;
                }
                int sum = nums[x] + nums[y] + nums[z];
                if (sum < 0){
                    continue;
                }
                else if (sum > 0){
                    z--;
                    y--;
                }
                else{
                    resultList.add(Arrays.asList(nums[x], nums[y], nums[z]));
                }
            }
        }
        return resultList;
    }
}