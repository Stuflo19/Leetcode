package Problem_1441;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<Integer> stack = new ArrayList<Integer>();
        List<String> operations = new ArrayList<String>();
        List<Integer> target2 = new ArrayList<>();
        for (int value : target) {
            target2.add(value);
        }

        for(int i = 1; i <= n; i++) {
            if(stack.equals(target2)) return operations;

            operations.add("Push");
            stack.add(i);

            if (!target2.contains(i)) {
                operations.add("Pop");
                stack.remove(stack.size() - 1);
            }
        }

        return operations;
    }
}
