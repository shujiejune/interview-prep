class Solution {
	public boolean isPalindrome(String s) {
		s.trim();
		s = s.toLowerCase();
		int i = 0, j = s.length();
		while (i < j) {
			while (i < j && !isValid(s.charAt(i))) {
				i++;
			}
			while (i < j && !isValid(s.charAt(j))) {
				j--;
			}
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
