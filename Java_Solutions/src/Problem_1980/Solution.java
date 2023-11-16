package Problem_1980;

class Solution {
    private boolean contains(String[] nums, String binary) {
        for (String num : nums) {
            if (num.equals(binary)) {
                return true;
            }
        }
        return false;
    }

    public String findDifferentBinaryString(String[] nums) {
        for (int i = 0; i < Math.pow(2, nums[0].length()); i++) {
            String binary = String.format("%" + nums[0].length() + "s", Integer.toBinaryString(i)).replace(' ', '0');
            System.out.println(binary);
            if (!contains(nums, binary)) {
                return binary;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] nums = {"01", "10"};
        System.out.println(s.findDifferentBinaryString(nums));
    }
}
