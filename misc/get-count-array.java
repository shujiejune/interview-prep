/* Given an array A of length N containing all positive integers 
 * from [1...N]. How to get an array B such that B[i] represents 
 * how many elements A[j] (j > i) in array A that are smaller than A[i].
 * Assumptions: The given array A is not null.
 * Requirement: Time complexity = O(nlogn)
 */
public class Solution {
	public int[] countArray(int[] array) {
		int n = array.length;
		int[] nearestSmaller = new int[n];
		Arrays.fill(nearestSmaller, -1);
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && array[stack.peekLast()] > array[i]) {
				nearestSmaller[stack.pollLast()] = i;
			}
			stack.offerLast(i);
		}
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int nsIdx = nearestSmaller[i];
			if (nsIdx != -1) {
				ans[i] = ans[nsIdx] + 1;
			}
		}
		return ans;
	}
}
