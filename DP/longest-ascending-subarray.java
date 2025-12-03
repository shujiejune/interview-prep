/* Given an unsorted array, find the length of the longest subarray
 * in which the numbers are in ascending order.
 */
public int longest(int[] array) {
	if (array == null || array.length == 0) {
		return 0;
	}
	int n = array.length;
	// dp[i] is the len of longest ascending subarr ending at index i
	int[] dp = new int[n];
	// base case
	dp[0] = 1;
	int longest = 0;
	for (int i = 1; i < n; i++) {
		// induction rule
		if (dp[i] > dp[i - 1]) {
			dp[i] = dp[i - 1] + 1;
		} else {
			dp[i] = 1;
		}
		longest = Math.max(longest, dp[i]);
	}
	return longest;
}

// Optimize space complexity to O(1):
// use a single variable to store longest ending at current index
// instead of a dp array
