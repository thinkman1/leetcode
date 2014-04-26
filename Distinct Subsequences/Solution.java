/**
 * 
 * @author thinkman
 *
 */
public class Solution {
    public int numDistinct(String S, String T) {
        int[][] res = new int[T.length()+1][S.length()+1];
        res[0][0] = 1;
        for (int i = 1; i < S.length()+1; i++) {
            res[0][i] = 1;
        }
        
        for (int i = 1; i < T.length()+1; i++) {
            res[i][0] = 0;
        }
        
        for (int i = 1; i < T.length()+1; i++) {
            for (int j = 1; j < S.length()+1; j++) {
                res[i][j] = res[i][j-1];
                if (S.charAt(j-1) == T.charAt(i-1)) {
                    res[i][j] += res[i-1][j-1];
                }
            }
        }
        
        return res[T.length()][S.length()];
    }
}