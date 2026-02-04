class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        int n = nums.length;
        
        // 1. 外层循环可以使用 for
        for (int x = 0; x < n - 2; x++) {
            if (nums[x] > 0) break; 
            
            // x 的去重逻辑是正确的
            if (x > 0 && nums[x] == nums[x - 1]) continue;
            
            int y = x + 1; // 左指针
            int z = n - 1; // 右指针
            
            // 2. 内层必须用 while，因为左右指针谁动不一定
            while (y < z) {
                int sum = nums[x] + nums[y] + nums[z];
                
                if (sum < 0) {
                    y++; // 和太小，左边往右移
                } else if (sum > 0) {
                    z--; // 和太大，右边往左移
                } else {
                    // 找到答案
                    resultList.add(Arrays.asList(nums[x], nums[y], nums[z]));
                    
                    // 3. 找到答案后，才开始去重，并且同时收缩
                    while (y < z && nums[y] == nums[y + 1]) y++;
                    while (y < z && nums[z] == nums[z - 1]) z--;
                    
                    y++;
                    z--;
                }
            }
        }
        return resultList;
    }
}