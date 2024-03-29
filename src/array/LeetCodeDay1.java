package array;

/**
 * 数组类型算法-最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组 是数组中的一个连续部分。
 * *
 * *  输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * *  输出：6
 * *  解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author hufei
 */
public class LeetCodeDay1 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMax(nums));
        ;
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static int findMax(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre, x);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() <= 2) return false;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < s2.length(); ++i) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (a != b) {
                sum += a - b;
                count++;
            }
        }
        if (count == 2) {
            return sum == 0;
        }
        return false;
    }

}
