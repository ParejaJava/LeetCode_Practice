class Solution {
    public boolean isPalindrome(String s) { // 双指针版
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String ssr = sb.toString(); 
        int L = 0;
        int R = ssr.length() - 1;
        
        while(L < R) {
            char ch1 = ssr.charAt(L);
            char ch2 = ssr.charAt(R);
            if (ch1 != ch2) {
                return false;
            } else {
                L++;
                R--;
            }
        }
        return true;
    }
}