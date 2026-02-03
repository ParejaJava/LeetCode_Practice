class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();//哈希表法（自己写的）
        for (int num : nums){
            table.put(num, table.getOrDefault(num, 0) + 1); //Gemini推荐的录数组新API
        }
        int maxtimes = 0;
        int most_num = 0;
        for (Map.Entry <Integer, Integer> entry : table.entrySet()){
            if (entry.getValue() > maxtimes){
                maxtimes = entry.getValue();
                most_num = entry.getKey();
            }

        }
        return most_num;
    }
}