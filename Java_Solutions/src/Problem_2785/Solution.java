package Problem_2785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
   public String sortVowels(String s) {
       // extract vowels from the word with their indexes sort them and insert them back in
       List<Character> vo = new ArrayList<>();
       List<Integer> indexes = new ArrayList<>();

       for(int i = 0; i < s.length(); i++) {
           char c = Character.toLowerCase(s.charAt(i));
           if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                   indexes.add(i);
                   vo.add(s.charAt(i));
           }
       }

       Collections.sort(vo);

       StringBuilder builder = new StringBuilder(s);
       for(int index : indexes) {
        builder.setCharAt(index, vo.remove(0));
       }

       return builder.toString();
   }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortVowels("Codewars"));
    }
}
