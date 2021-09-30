package no300;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *  
 *
 * 进阶：
 *
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No326 {
    public boolean isPowerOfThree(int n) {
        if(n==1||n==3||n==9||n==27||n==81||n==243||n==729||n==2187||n==6561||n==19683||n==59049||n==177147||n==531441||n==1594323||n==4782969||n==14348907||n==43046721||n==129140163||n==387420489||n==1162261467){
            return true;
        }
        return false;
    }
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    public boolean isPowerOfThree0(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }

    public static void main(String[] args) {
        int num = 1;
        List<Integer> nums = new ArrayList<>();
        while(num>0) {
            nums.add(num);
            num = num * 3;
        }
        for (Integer integer : nums) {
            System.out.println(integer);
        }
    }
}
