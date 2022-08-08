package bit;


/**
 * @author hufei
 */
public class Solution {
    public static void main(String[] args) {
        int res = majorityElement(new int[]{2,1,3,2,3,2});
        System.out.println(res);
        boolean abcdefg = isUnique("abcdefg");
        System.out.println(abcdefg);
    }

    /**
     * 找出多数元素
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
     * @param astr "abcdefg"
     * @return true
     */
    public static boolean isUnique(String astr) {
        if(astr.length() > 26) {
            return false;
        }
        int[] bit = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            if (bit[index] > 0) {
                return false;
            }
            bit[index]++;
        }
        return true;
    }

    /**
     * 判断字符串是否是唯一的
     * @param astr "abcdefg"
     * @return true
     */
    public static boolean isUnique2(String astr) {
        return astr.chars().distinct().count() == astr.length();
    }
}
