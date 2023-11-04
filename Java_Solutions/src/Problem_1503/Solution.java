package Problem_1503;

public class Solution {
    private int findMax(int[] arr) {
        int max = 0;

        for(int e : arr) {
            if(e > max) {
                max = e;
            }
        };

        return max;
    }

    private int findMin(int[] arr) {
        int min = 100000000;

        for(int e : arr) {
            if(e < min) {
                min = e;
            }
        };

        return min;
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int minRight = findMin(right);
        int maxLeft = findMax(left);

        if(n - minRight > Math.abs(0 - maxLeft)) {
            return n - minRight;
        } else {
            return maxLeft;
        }
    }
}


