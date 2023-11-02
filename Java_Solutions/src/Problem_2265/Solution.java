package Problem_2265;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TrackedInfo {
    int total = 0;
    int numNodes = 0;
    int totalMatches = 0;

    TrackedInfo() {}

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String toString() {
        return "Total: " + total + "\nTotalMatches: " + totalMatches + "\nnumNodes: " + numNodes;
    }

    public void combine(TrackedInfo combiner) {
        this.total += combiner.getTotal();
        this.numNodes += combiner.getNumNodes();
        this.totalMatches += combiner.getTotalMatches();
    }
}

class Solution {
    public TrackedInfo recursiveSearch(TreeNode node) {
        TrackedInfo ti = new TrackedInfo();
        if(node.right != null) ti.combine(recursiveSearch(node.right));

        if(node.left != null) ti.combine(recursiveSearch(node.left));

        ti.setNumNodes(ti.getNumNodes() + 1);
        ti.setTotal(ti.getTotal() + node.val);

        if((ti.getTotal() / ti.getNumNodes()) == node.val) ti.setTotalMatches(ti.getTotalMatches() + 1);

        return ti;
    }

    public int averageOfSubtree(TreeNode root) {
        return recursiveSearch(root).getTotalMatches();
    }
}




