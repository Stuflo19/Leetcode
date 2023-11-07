package Problem_1921;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int index = 0;
    List<Double> monsters = new ArrayList<>();

    public int eliminateMaximum(int[] dist, int[] speed) {
        while(index < dist.length) {
            double turnsToEnd;
            int di = dist[index];
            int sp = speed[index];
            if(di - sp == 0) turnsToEnd = 0;
            else turnsToEnd = Math.ceil((double) di / sp);
            monsters.add(turnsToEnd);
            index++;
        }

        monsters.sort(null);

        for(int i = 1; i < monsters.size(); i++) {
            if(monsters.get(i) >= monsters.get(i - 1) && i < monsters.get(i)) continue;
            else return i;
        }

        return 0;
        // return findAns(dist.length);
    }
}

class Runner {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int result = sol.eliminateMaximum(new int[]{3, 2, 8}, new int[]{2, 1, 4});

        System.out.println(result);
    }
}

