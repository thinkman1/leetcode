/**
 * 
 * @author thinkman
 *
 */
public class Solution {
    public void sortColors(int[] A) {
        int red = 0;
        int blue = A.length-1;
        int i = 0;
        while (i <= blue) {
            if (A[i] == 0) {
                swap(i, red, A);
                red++;
                i++;
            } else if (A[i] == 2) {
                swap(i, blue, A);
                blue--;
            } else {
                i++;
            }
        }
    }
    
    public void swap(int i , int j, int[] A) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}