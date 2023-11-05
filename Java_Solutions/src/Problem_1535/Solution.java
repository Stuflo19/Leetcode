package Problem_1535;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int getWinner(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        for (int n : arr) {
            list.add(n);
        }

        int winCount = 0;
        int currWinner = list.get(0);

        while (winCount != k) {
            if (arr.length == 1) {
                return list.get(0);
            } else if (list.size() < winCount) {
                return currWinner;
            } else if (list.get(0) > list.get(1)) {
                winCount++;
                int loser = list.remove(1);
                list.add(loser);
            } else {
                winCount = 1;
                currWinner = list.get(1);
                int loser = list.remove(0);
                list.add(loser);
            }
        }

        return currWinner;
    }
}
