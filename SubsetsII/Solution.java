/**
 * without using Set
 * 
 * @author thinkman
 *
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) return res;
		Arrays.sort(num);
		generate(0, new ArrayList<Integer>(), res, num);
		return res;
	}

	public void generate(int step, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res, int[] num) {
		res.add(new ArrayList<Integer>(list));

		for (int i = step; i < num.length; i++) {
			list.add(num[i]);
			generate(i + 1, list, res, num);
			list.remove(list.size() - 1);

			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
}