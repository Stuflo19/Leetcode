package Problem_1930;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> palindromes = new HashSet<>();
        char[] chars = s.toCharArray(); 
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < chars.length; i++) {
            map.putIfAbsent(chars[i], new ArrayList<>());
            //compare index [0] and [1] where index 0 in min and 1 is max
            if(map.get(chars[i]).size() == 2) {
                map.get(chars[i]).set(0, Math.min(map.get(chars[i]).get(0), i));
                map.get(chars[i]).set(1, Math.max(map.get(chars[i]).get(1), i));
            } else {
                map.get(chars[i]).add(i);
                map.get(chars[i]).add(i);
            }
        }

        for(int i = 1; i < chars.length; i++) {
            for(char c : map.keySet()) {
                if(map.get(c).get(0) < i && i < map.get(c).get(1)) {
                    palindromes.add("" + c + chars[i] + c);
                }
            }
        }

        return palindromes.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Result: " + solution.countPalindromicSubsequence("aabca"));
        System.out.println("Result: " + solution.countPalindromicSubsequence("adc"));
        System.out.println("Result: " + solution.countPalindromicSubsequence("bbcbaba"));
    }
}

