package Problem_501;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a binary tree node.
 private class TreeNode {
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

class Solution {
    private void recursiveSearch(HashMap<Integer, Integer> integerCountMap, TreeNode node) {
        integerCountMap.put(node.val, integerCountMap.getOrDefault(node.val, 0) + 1);

        if(node.right != null) recursiveSearch(integerCountMap, node.right);
        if(node.left != null) recursiveSearch(integerCountMap, node.left);
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> integerCountMap = new HashMap<>();

        recursiveSearch(integerCountMap, root);

        int max = 0;
        List<Integer> resultList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : integerCountMap.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                resultList.clear();
                resultList.add(entry.getKey());
            } else if(entry.getValue() == max) {
                resultList.add(entry.getKey());
            }
        }

        int[] resultList2 = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultList2[i] = resultList.get(i);
        }

        return resultList2;
    }
}
