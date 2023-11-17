package Problem_1877;
import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        int startPointer = 0;
        int endPointer = nums.length - 1;
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);

        while(startPointer < endPointer) {
            if(nums[startPointer] + nums[endPointer] > max) {
                max = nums[startPointer] + nums[endPointer];
            }
            startPointer++;
            endPointer--;
        }

        return max;
    }
}
