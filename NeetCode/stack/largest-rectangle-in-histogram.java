class Solution {
	public int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new ArrayDeque<>();
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int h = heights[i];
			while (!stack.isEmpty() && heights[stack.peekLast()] >= h) {
				stack.pollLast();
			}
			int left = stack.isEmpty() ? 0 : stack.peekLast();
			int w = i - left;
			maxArea = Math.max(maxArea, h * w);
			stack.offerLast(i);
		}
		return maxArea;
	}
}
