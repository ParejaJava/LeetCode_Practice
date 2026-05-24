class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if(!map.containsKey(c)) { // 是左括号
                st.push(c);
            } else if (st.isEmpty() || st.pop() != map.get(c)) {
                return false;
            }
        }

        return st.isEmpty();
    }
}