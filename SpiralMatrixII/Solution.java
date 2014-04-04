public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int start = 0, end = n-1;
        int k = 1;
        
        while (start < end) {
            for (int i = start; i < end; i++) {
                res[start][i] = k++;
            }
            
            for (int i = start; i < end; i++) {
                res[i][end] = k++;
            }
            
            for (int i = end; i > start; i--) {
                res[end][i] = k++;
            }
            
            for (int i = end; i > start; i--) {
                res[i][start] = k++;
            }
            
            start++;
            end--;
        }
        
        if (start == end) {
            res[start][end] = k;
        }
        
        return res;
    }
}