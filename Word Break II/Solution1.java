/**
 * This one is better!!
 * 
 * @author thinkman
 *
 */
public class Solution1 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 0) return res;
        boolean[] possible = new boolean[s.length()+1];
        Arrays.fill(possible, true);
        breakWord(0, new StringBuilder(), res, s, dict, possible);
        return res;
    }
    
    public void breakWord(int step, StringBuilder sb, ArrayList<String> res, String s, Set<String> dict, boolean[] possible) {
        if (step == s.length()) {
            int size = sb.length();
            res.add(sb.toString().substring(0, size-1));
            return;
        }
        
        for (int i = step; i < s.length(); i++) {
            String ss = s.substring(step, i+1);
            if (dict.contains(ss) && possible[i+1]) {
                int before = sb.length();
                int beforeChange = res.size();
                sb.append(ss).append(" ");
                breakWord(i+1, sb, res, s, dict, possible);
                if (beforeChange == res.size()) {
                    possible[i+1] = false;
                }
                sb.delete(before, sb.length());
            }
        }
    }
}