package bit;


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
        int reverseBits = reverseBits(99999999);

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

    public static int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    public static int reverseBits2(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            // 00 & 1
            rev = rev << 1 & n | 0;

        }
        return 1;
    }
}
