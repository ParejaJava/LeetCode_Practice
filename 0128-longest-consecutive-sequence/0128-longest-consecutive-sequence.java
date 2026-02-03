class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int score = 0;
        for (int num : set){
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