/* Given a string, returns the length of the longest substring without duplicate characters. */
public int longestUnique(String input) {
	if (input == null || input.length() == 0) {
		return 0;
	}
	int n = input.length();
	int maxCount = 0;
	int i = 0, j = 0;
	Set<Character> occur = new HashSet<>();
	while (j < n) {
		char c = input.charAt(j);
		if (!occur.contains(c)) {
			occur.add(c);
			count++;
			j++;
		} else {
			maxCount = Math.max(maxCount, j - i);
			while (input.charAt(i) != c) {
				occur.remove(input.charAt(i));
				i++;
			}
			i++;
			j++;
		}
	}
	maxCount = Math.max(maxCount, j - i);
	return maxCount;
}
