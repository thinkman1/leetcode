/**
 * 
 * @author thinkman
 *
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        
        int row = s1.length()+1;
        int col = s2.length()+1;
        
        boolean[][] res = new boolean[row][col];
        res[0][0] = true;
        for (int i = 1; i < row; i++) {
            res[i][0] = s3.charAt(i-1) == s1.charAt(i-1);
        }
        
        for (int i = 1; i < col; i++) {
            res[0][i] = s3.charAt(i-1) == s2.charAt(i-1);
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) != s3.charAt(i+j-1)) {
                    res[i][j] = res[i-1][j];
                } else if (s1.charAt(i-1) != s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    res[i][j] = res[i][j-1];
                } else if (s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    res[i][j] = res[i-1][j] || res[i][j-1];
                } else {
                    res[i][j] = false;
                }
            }
        }
        
        return res[row-1][col-1];
    }
}