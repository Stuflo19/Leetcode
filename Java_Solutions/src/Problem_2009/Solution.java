package Problem_2009;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

class Solution {
//    public static int minOperations(int[] nums) {
//        HashMap<Integer, Integer> count = new HashMap();
//        int min = 1000000000;
//        int max = 0;
//
//        for(int i : nums) {
//            if(i > max) max = i;
//            if(i < min) min = i;
//
//            if(!count.containsKey(i)) {
//                count.put(i, 1);
//            } else {
//                count.replace(i,  count.getOrDefault(i, 1) + 1);
//            }
//        }
//
//        if(Collections.max(count.values()) == 1 && max - min == nums.length -1) {
//            return 0;
//        } else {
//            int numChanges = 0;
//            for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
//                if(entry.getValue() > 1) {
//                    numChanges += (entry.getValue() - 1);
//                } else if (entry.getKey() - min > nums.length - 1) {
//                    numChanges++;
//                }
//            }
//            return numChanges;
//        }
//    }


    public static int minOperations(int[] nums) {
//      Sort the given array
        Arrays.sort(nums);

//      Remove duplicates from array
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i--]) nums[i] = nums[i++];
        }

        System.out.println(Arrays.toString(nums));

        return 0;
    }

    public static void main(String[] args) {
//        int res = minOperations(new int[]{1,2,3,5,6});
//        int res = minOperations(new int[]{4,2,5,3});
//        int res = minOperations(new int[]{1,10,100,1000});
        int res = minOperations(new int[]{41,33,29,33,35,26,47,24,18,28});

        System.out.println("Result: " + res);
    }
}
