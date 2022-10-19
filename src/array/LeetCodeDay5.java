package array;

import java.util.HashMap;
import java.util.Map;

/**
 * create by hufei on 2022-10-17 09:02
 */
public class LeetCodeDay5 {
    public static void main(String[] args) {
        totalFruit(new int[]{1,2,1,3,4,5,6});
    }

    /**
     * 水果成篮
     * @param fruits [1,2,1,3,4,5,6]
     * @return 5
     */
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            // 重复的水果，HASH表中的value值+1
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            // 当前水果种类大于2，左指针右移
            while (cnt.size() > 2) {
                // 左指针右移，HASH表中的value值-1
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            // 计算最大值
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
