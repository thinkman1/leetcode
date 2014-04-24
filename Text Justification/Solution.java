public class Solution {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		String[] spaces = new String[L + 1];
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < L + 1; i++) {
			spaces[i] = builder.toString();
			builder.append(" ");
		}
		
		int len = words.length;
		int start = 0;
		while (start < len) {
			int j = start;
			int total = words[start].length();
			while (true) {
				j++;
				if (j == len) break;
				int w = words[j].length();
				if (total + w + 1 > L) break;
				total += w + 1;
			}
			int left = L - total;
			int c = j - start;
			if (c == 1) { // single word
				StringBuilder sb = new StringBuilder(words[start]);
				sb.append(spaces[left]);
				result.add(sb.toString());
			} else { // multi-word
				if (j == len) { // last line
					StringBuilder sb = new StringBuilder(words[start]);
					for (int x = start + 1; x < j; x++) {
						sb.append(" ");
						sb.append(words[x]);
					}
					sb.append(spaces[left]);
					result.add(sb.toString());
				} else {
					int k = left / (c - 1); // extra ' ' for every gap
					int l = left - k * (c - 1); // count for first gaps with extra ''
					StringBuilder sb = new StringBuilder(words[start]);
					for (int x = start + 1; x < j; x++) {
						if (l > 0) {
							sb.append(" ");
							l--;
						}
						sb.append(" ");
						sb.append(spaces[k]);
						sb.append(words[x]);
					}
					result.add(sb.toString());
				}
			}
			start = j;
		}
		return result;
	}
}