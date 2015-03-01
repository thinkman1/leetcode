public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String first = strs[0];
		
		for (int i = 0; i < first.length(); i++) {
			String prefix = first.substring(0, i + 1);
			for (int j = 1; j < strs.length; j++) {
				if (!strs[j].startsWith(prefix)) {
					if (i == 0)
						return "";
					else
						return first.substring(0, i);
				}
			}
		}
		return first;
	}
}