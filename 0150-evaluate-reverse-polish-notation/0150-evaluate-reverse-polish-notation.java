class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String token : tokens) {
            char c = token.charAt(0);
            if (token.length() > 1 || Character.isDigit(c)) {// 是不是数字，必须要双判
                st.push(Integer.parseInt(token));
                continue;
            }
            int x = st.pop();
            int y = st.pop(); // 先进的
            if (c == '+') {
                st.push(x + y);
            } 
            if (c == '-') {
                st.push(y - x);
            } 
            if (c == '*') {
                st.push(x * y);
            } 
            if (c == '/') {
                st.push(y / x);
            } 
        }
        return st.pop();
    }
}