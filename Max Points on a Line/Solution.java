/**
 * @author thinkman
 *
 */
public class Solution {
	public int maxPoints(Point[] points) {
		if (points.length == 0)
			return 0;
		int res = 1;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();

		for (int i = 0; i < points.length; i++) {
			int dup = 1;
			int vertical = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						dup++;
					} else {
						vertical++;
					}
					continue;
				}

				double slope = points[j].y - points[i].y == 0 ? 0.0 : 1.0
						* (points[j].y - points[i].y)
						/ (points[j].x - points[i].x);
				if (map.containsKey(slope)) {
					map.put(slope, map.get(slope) + 1);
				} else {
					map.put(slope, 1);
				}
			}

			for (Integer sum : map.values()) {
				res = Math.max(res, sum + dup);
			}

			res = Math.max(res, dup + vertical);
			map.clear();
		}
		return res;
	}
}