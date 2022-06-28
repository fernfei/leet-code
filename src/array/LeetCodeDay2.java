package array;

/**
 * 数组类型算法-加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 * 来回切换中英文才把题目看懂，数组每位都是single digit，所以只能是0-9的个位数，整个数没有leading zero，
 * 意思就是数组第一个数必非0，再就是要注意，像[9,9]输出就是[1,0,0]。
 * 刚开始的思路是把数组先转化成数字，加一再转化回来，自己测试也成功了，提交之后发现忽略了整型溢出的情况。后来发现用数组本身来求解更简单...
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * @author hufei
 */
public class LeetCodeDay2 {

    public static void main(String[] args) {
        LeetCodeDay2 leetCodeDay2 = new LeetCodeDay2();
        int[] digits = {9, 9, 2};
        int[] result = leetCodeDay2.plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
