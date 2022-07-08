package Main.Leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/two-sum/

        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        TwoSum leetcode = new TwoSum();
        int[] ints = leetcode.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}