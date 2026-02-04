class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // 排序+双指针(while循环标准版)
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
            int y = x + 1;
            int z = n - 1;
            while (y < z) {
                if (y > x + 1 && nums[y] == nums[y - 1]){
                    y++;
                    continue;
                }
                if (z < n - 1 && nums[z] == nums[z + 1]){
                    z--;
                    continue;
                }
                int sum = nums[x] + nums[y] + nums[z];
                if (sum < 0){
                    y++;
                } else if (sum > 0){
                    z--;
                } else{
                    resultList.add(Arrays.asList(nums[x], nums[y], nums[z]));
                    y++;
                    z--;
                }
            }
        }
        return resultList;
    }
}