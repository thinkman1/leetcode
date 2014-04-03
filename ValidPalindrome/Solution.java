public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        return isPal(0, s.length()-1, s);
    }
    
    public boolean isPal(int start, int end, String s) {
        while (start <= end) {
            while (start < s.length()-1 && !isValid(s.charAt(start))) {
                start++;
            }
            while (end > 0 && !isValid(s.charAt(end))) {
                end--;
            }
            
            if (isValid(s.charAt(start)) && isValid(s.charAt(end)) && s.charAt(start) != s.charAt(end)) return false;
            
            start++;
            end--;
        }
        return true;
    }
    
    public boolean isValid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}