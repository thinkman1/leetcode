/**
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		HashMap map = init();
		combine(0, digits, map, new StringBuilder(), res);
		return res;
	}

	public void combine(int step, String digits,
			HashMap<Character, String> map, StringBuilder sb,
			ArrayList<String> res) {
		if (step == digits.length()) {
			res.add(sb.toString());
			return;
		}

		String mappings = map.get(digits.charAt(step));
		for (int i = 0; i < mappings.length(); i++) {
			int before = sb.length();
			sb.append(mappings.charAt(i));
			combine(step + 1, digits, map, sb, res);
			sb.delete(before, sb.length());
		}
	}

	public HashMap<Character, String> init() {
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('0', " ");
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		return map;
	}
}