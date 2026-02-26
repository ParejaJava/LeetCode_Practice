class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> iStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                iStack.push(i);
                continue;
            }
            while (!iStack.isEmpty() && temperatures[i] > temperatures[iStack.peek()]) {
                int j = iStack.pop();
                answer[j] = i - j;
            }
            iStack.push(i);
        }
        return answer;
    }
}