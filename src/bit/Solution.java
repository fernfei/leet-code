package bit;


import java.util.LinkedList;
import java.util.List;

/**
 * @author hufei
 */
public class Solution {
    public static void main(String[] args) {
        // 多数元素测试
        int res = majorityElement(new int[]{2, 1, 3, 2, 3, 2});
        // 判断字符是否唯一测试
        boolean abcdefg = isUnique("abcdefg");
        // 判断字符串是否是排列回文
        boolean code = canPermutePalindrome("9y");
        // 反转二进制
        int reverseBits = reverseBits2(-11);
        // 位1个数
        int hammingWeight = hammingWeight(-11);
        // 二进制手表
        List<String> readBinaryWatch = readBinaryWatch2(1);
        // 二进制转十六进制
        String hex = toHex(998);
        // 数字的补数
        int complement = findComplement(5);

    }

    /**
     * 找出多数元素
     *
     * @param nums [3,1,3]
     * @return 3;
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }
            count += (num == majority) ? 1 : -1;
        }
        return majority;
    }

    /**
     * 判断字符串是否是唯一的
     *
     * @param astr "abcdefg"
     * @return true
     */
    public static boolean isUnique(String astr) {
        if (astr.length() > 26) {
            return false;
        }
        boolean[] bit = new boolean[26];
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            if (bit[index]) {
                return false;
            }
            bit[index] = true;
        }
        return true;
    }


    /**
     * 判断字符串是否是唯一的
     *
     * @param astr "abcdefg"
     * @return true
     */
    public static boolean isUnique2(String astr) {
        return astr.chars().distinct().count() == astr.length();
    }

    /**
     * 判断字符串是否是唯一的
     *
     * @param astr "abcdefg"
     * @return true
     */
    public static boolean isUnique3(String astr) {
        int mask = 0;
        for (int i = 0; i < astr.length(); i++) {
            if ((mask & (1 << astr.charAt(i) - 'a')) != 0) {
                return false;
            } else {
                mask |= 1 << astr.charAt(i) - 'a';
            }
        }
        return true;
    }

    /**
     * 判断字符串是否是排列回文
     *
     * @param s 字符串
     * @return true是 false否
     */
    public static boolean canPermutePalindrome(String s) {
        long front = 0, end = 0;
        for (char c : s.toCharArray()) {
            if (c > 64) {
                front ^= 1L << (c - 64);
            } else {
                end ^= 1L << c;
            }
        }
        return Long.bitCount(front) + Long.bitCount(end) <= 1;
    }

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    /**
     * 反转二进制数 例 1100 结果 0011
     *
     * @param n 十进制数
     * @return 反转后的十进制数
     */
    public static int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    /**
     * 反转二进制数 例 1100 结果 0011
     *
     * @param n 十进制数
     * @return 反转后的十进制数
     */
    public static int reverseBits2(int n) {
        int rev = 0;
        // 1100 0
        // 110  0
        // 11   00
        // 1    001
        // 0    0011
        for (int i = 0; i < 32 && n != 0; i++) {
            // 00 & 1
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }


    /**
     * 一个十进制数的二进制数位1的个数
     *
     * @param n 1011 结果 3
     * @return 位1个数
     */
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 丢失的数字
     *
     * @param nums 数字数组
     * @return 丢失的数字
     */
    public int missingNumber(int[] nums) {
        int numsSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            numsSum ^= nums[i];
        }
        for (int i = 0; i <= nums.length; ++i) {
            sum ^= i;
        }
        return sum ^ numsSum;
    }

    /**
     * 不同的字符串
     *
     * @param s aab
     * @param t aa
     * @return b
     */
    public char findTheDifference(String s, String t) {
        int mask = 0;
        for (int i = 0; i < t.length(); ++i) {
            mask ^= s.charAt(i) - '0';
        }

        for (int i = 0; i < t.length(); ++i) {
            mask ^= t.charAt(i) - '0';
        }
        return (char) (mask + '0');
    }

    /**
     * 二进制手表
     *
     * @param turnedOn 二进制手表组合个数
     * @return 结果
     */
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new LinkedList();
        // 1 2 4 8 hour 0-11
        // 1 2 4 8 16 32 minutes 0-59
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 60; ++j) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    ans.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return ans;
    }

    /**
     * 二进制手表
     *
     * @param turnOn 二进制手表组合个数
     * @return 结果
     */
    public static List<String> readBinaryWatch2(int turnOn) {
        // 高4位表示 开关闭合状态表示小时 低6位表示分制
        // 0001 000000
        // 0010 000000
        // 0100 000000
        // 1000 000000
        // 0000 100000
        // 0000 010000
        // 0000 001000
        // 0000 000100
        // 0000 000010
        // 0000 000001
        List<String> ans = new LinkedList();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6, m = i & 63;
            if (h < 12 && m < 60 && (Integer.bitCount(i) == turnOn)) {
                ans.add(h + ":" + (m < 10 ? "0" + m : m));
            }
        }
        return ans;
    }

    /**
     * 十进制转十六进制
     *
     * @param num 十进制数
     * @return 十六机制数
     */
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    /**
     * 数字的补数
     *
     * @param num 十进制数字
     * @return 补数
     */
    public static int findComplement(int num) {
        int len = 0;
        for (int i = 0; i < 31; ++i) {
            // 101 i==2 111
            if (num >= (1 << i)) {
                len = i;
            } else {
                break;
            }
        }
        int mask = (1 << (len + 1)) - 1;
        return num ^ mask;
    }
}
