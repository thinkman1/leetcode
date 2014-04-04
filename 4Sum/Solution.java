/**
 * O(n^3).. should be better.
 * 
 * @author thinkman
 *
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4) return res;
        
        Arrays.sort(num);
        for (int i = 0; i < num.length-3; i++) {
            if (i > 0 && num[i-1] == num[i]) continue;
            for (int j = i+1; j < num.length-2; j++) {
                if (j > i+1 && num[j-1] == num[j]) continue;
                
                int start = j+1;
                int end = num.length-1;
                
                while (start < end) {
                    int sum = num[i] + num[j] + num[start] + num[end];
                    if (sum > target) {
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        res.add(list);
                        
                        do { start++; } while (start < end && num[start-1] == num[start]);
                        do { end--; } while (start < end && num[end+1] == num[end]);
                    }
                }
            }
        }
        
        return res;
    }
}