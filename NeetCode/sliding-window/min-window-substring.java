class Solution {
	public String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		Map<Character, Integer> freq = new HashMap<>();
		for (char c : t.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		int i = 0, j = 0, count = 0;
		int[] bounds = new int[2]{-1, -1};
		int minLen = s.length();
		while (j < s.length()) {
			char c = s.charAt(j);
			if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) - 1);
				count++;
				while (i <= j && freq.get(c) < 0) {
					char left = s.charAt(i);
					if (freq.containsKey(left)) {
						if (freq.get(left) >= 0) { break; }
						freq.put(left, freq.get(left) + 1);
					}
					i++;
				}
				while (i <= j && !freq.containsKey(s.charAt(i))) {
					i++;
				}
			}
			j++;
			if (count == t.length()) {
				int len = j - i;
				if (len < minLen) {
					minLen = len;
					bounds[0] = i;
					bounds[1] = j;
				}
			}
		}
		if (bounds[0] == -1) {
			return "";
		} else {
			return s.substring(bounds[0], bounds[1]);
		}
	}
}
