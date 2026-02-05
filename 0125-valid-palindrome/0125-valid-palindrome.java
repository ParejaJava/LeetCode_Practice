class Solution {
    public boolean isPalindrome(String s) { // API版
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String ssr = sb.toString();
        String sr = sb.reverse().toString();
        return sr.equals(ssr);
    }
}