/**
 * Day 6 - Cousins in Binary Tree
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Example 1: Input: root = [1,2,3,4], x = 4, y = 3 Output: false
 *      1
 *     / \
 *    2   3
 *   /
 *  4
 * Example 2: Input: [2,2,1,1,1,2,2], Output: 2
 *      1
 *     / \
 *    2   3
 *     \   \
 *      4   5
 * Example 3: Input: root = [1,2,3,null,4], x = 2, y = 3, Output: false
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 
 * Note:
 *  The number of nodes in the tree will be between 2 and 100.
 *  Each node has a unique integer value from 1 to 100.
 * 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /** Non-recursive solution */
    public boolean isCousins(TreeNode root, int x, int y) {
        return (height(root, x, 1) == height(root, y, 1)) && (!isSameParent(root, x, y));
    }
    
    private int height(TreeNode root, int x, int h){
        if(root == null) return 0;
        if(root.val == x) return h;
        int lh = height(root.left, x, h+1);
        if(lh != 0) return lh;
        return height(root.right, x, h+1);
    }
    
    private boolean isSameParent(TreeNode root, int x, int y){
        if(root == null) return false;
        if(root.left == null) return isSameParent(root.right, x, y);
        else if(root.right == null) return isSameParent(root.left, x, y);
        else return (root.left.val == x && root.right.val == y)
            || (root.left.val == y && root.right.val == x)
            || isSameParent(root.left, x, y)
            || isSameParent(root.right, x, y);
    }
}

    /** Non-recursive solution */
    /*
    public boolean isCousins(TreeNode root, int x, int y) {
       
    // Queue for BFS
        Queue <TreeNode> queue = new LinkedList <> ();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = queue.size();

            for (int i = 0; i < nodesAtDepth; i++) {
                // FIFO
                TreeNode node = queue.remove();

                // Encountered the marker.
                // Siblings should be set to false as we are crossing the boundary.
                if (node == null) {
                    siblings = false;
                } else {
                    if (node.val == x || node.val == y) {
                        // Set both the siblings and cousins flag to true
                        // for a potential first sibling/cousin found.
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            // If the siblings flag is still true this means we are still
                            // within the siblings boundary and hence the nodes are not cousins.
                            return !siblings;
                        }
                    }

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    // Adding the null marker for the siblings
                    queue.add(null);
                }
            }
            // After the end of a level if `cousins` is set to true
            // This means we found only one node at this level
            if (cousins) return false;
        }
        return false;
    }
    */