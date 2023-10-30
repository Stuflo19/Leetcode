import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
       Solution solution = new Solution();

        Arrays.stream(solution.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})).forEach(System.out::println);
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] converted = Arrays.stream( arr ).boxed().toArray( Integer[]::new );
        Arrays.sort(converted, new SortByCount());

        return Arrays.stream(converted).mapToInt(i->i).toArray();
    }
}

class SortByCount implements Comparator<Integer> {
    private int countInstances(Integer value) {
        String binaryString = Integer.toBinaryString(value);
        return Math.toIntExact(binaryString.chars().filter((c) -> c == 49).count());
    }

    @Override
    public int compare(Integer a, Integer b) {
        return countInstances(a) - countInstances(b);
    }
}
