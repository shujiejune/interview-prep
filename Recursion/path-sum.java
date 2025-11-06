/*
Given a binary tree in which each node contains an int,
find the max possible sum from any node to any node 
(the start node and the end node can be the same).
*/
public int maxPathSum(TreeNode root) {
	int[] globalMax = new int[1];
	globalMax[0] = Integer.MIN_VALUE;
	maxStraightPathSum(root, globalMax);
	return globalMax[0];
}

private int maxStraightPathSum(TreeNode root, int[] globalMax) {
	if (root == null) {
		return 0;
	}
	int leftMax = maxStraightPathSum(root.left, globalMax);
	int rightMax = maxStraightPathSum(root.right, globalMax);
	int childMax = Math.max(leftMax, rightMax);
	int currMax = root.key + Math.max(leftMax, 0) + Math.max(rightMax, 0);
	globalMax[0] = Math.max(globalMax[0], currMax);
	return Math.max(childMax, 0) + root.key;
}
