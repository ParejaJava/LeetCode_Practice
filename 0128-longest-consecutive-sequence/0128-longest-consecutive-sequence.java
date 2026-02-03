class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); //先把数组存入哈希set去重
        for (int num : nums){
            set.add(num);
        }
        int score = 0;
        for (int num : set){ //这里记得用新哈希表遍历
            if (!set.contains(num - 1)){
                int curr_num = num;
                int curr_length = 1;
                while (set.contains(curr_num + 1)){
                    curr_length += 1;
                    curr_num += 1;
                }
            score = Math.max(score, curr_length);   
            } 
        }
        return score;
    }
}
