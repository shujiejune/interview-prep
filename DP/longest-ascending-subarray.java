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


/* longest ascending subsequence 
 * return the subsequence
 */
public class Solution {
	public int[] longest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int n = array.length;
		int globalMax = 1;
		// dp[i]: length of longest ascending subsequence ending at array[i]
		int[] dp = new int[n];
		int[] prev = new int[n];
		Arrays.fill(dp, 1);
		int longestEndIndex = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i]) {
					if (dp[j] + 1 > dp[i]) {
						prev[i] = j;
						dp[i] = dp[j] + 1;
					}
				}
			}
			if (dp[i] > globalMax) {
				globalMax = dp[i];
				longestEndIndex = i;
			}
		}
		int[] ans = new int[globalMax];
		int index = longestEndIndex;
		for (int i = globalMax - 1; i >= 0; i--) {
			ans[i] = array[index];
			index = prev[index];
		}
		return ans;
	}
}


/* count ascending subseuqences */
public class Solution {
	public int numIncreasingSubsequences(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int n = a.length;
		int sum = 0;
		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i]) {
					dp[i] += dp[j];
				}
			}
			dp[i]++;
			sum += dp[i];
		}
		return sum;
	}
}
