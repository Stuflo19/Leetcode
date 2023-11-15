package Problem_1846;

import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = 1;
        Arrays.sort(arr); 
        System.out.println(Arrays.toString(arr));

        if(arr[0] != 1) {
            arr[0] = 1;
        }

        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[i-1]) > 1) {
                arr[i] = arr[i-1] + 1;

            } 
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(Arrays.toString(arr));

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(new int[]{1, 100, 1000}));
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }

}
