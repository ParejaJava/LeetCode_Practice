class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        int newtimes = 0;
        for (int num : nums){
            if (!table.containsKey(num)){
                table.put(num, 1);
            }
            else{
                newtimes = table.get(num) + 1;
                table.put(num, newtimes);
            }
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