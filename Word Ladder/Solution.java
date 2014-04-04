/**
 * 
 * @author thinkman
 *
 */
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.equals(end) || dict.isEmpty()) return 0;
    
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> seqs = new LinkedList<Integer>();
        
        words.add(start);
        seqs.add(1);
        
        while (!words.isEmpty()) {
            
            String word = words.remove();
            int seq = seqs.remove();
            
            if (word.equals(end)) return seq;
            
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[i] == c) continue;
                    
                    chars[i] = c;
                    String w = String.valueOf(chars);
                    
                    if (dict.contains(w)) {
                        words.add(w);
                        seqs.add(seq+1);
                        dict.remove(w);
                    }
                }
            }
        }
        
        return 0;
    }
}