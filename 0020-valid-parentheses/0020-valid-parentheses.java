class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            ']', '[',
            '}', '{');
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();            
            }
            else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}