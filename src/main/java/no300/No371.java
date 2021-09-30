package no300;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 *  
 *
 * 提示：
 *
 * -1000 <= a, b <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No371 {

    public static void main(String[] args) {
        int sum = getSum(-1000,500);
        System.out.println(sum);
        /**
         * -1000
         * 500
         * 11111111111111111111110000011000
         * 00000000000000000000000111110100
         * -----------
         * -532
         * 32
         * 11111111111111111111110111101100
         * 00000000000000000000000000100000
         * -----------
         * -564
         * 64
         * 11111111111111111111110111001100
         * 00000000000000000000000001000000
         * -----------
         * -628
         * 128
         * 11111111111111111111110110001100
         * 00000000000000000000000010000000
         * -----------
         * -756
         * 256
         * 11111111111111111111110100001100
         * 00000000000000000000000100000000
         * -----------
         * -1012
         * 512
         * 11111111111111111111110000001100
         * 00000000000000000000001000000000
         * -----------
         * -500
         * 0
         * 11111111111111111111111000001100
         * 00000000000000000000000000000000
         * -----------
         * -500
         */
    }
    public static int getSum(int a, int b) {
        while(b!=0){
            System.out.println(a);
            System.out.println(b);
            System.out.println(toBinaryString(a));
            System.out.println(toBinaryString(b));
            System.out.println("-----------");
            int tempA = a;
            int tempB = b;
            a = tempA ^ tempB;
            b = (tempA & tempB) << 1;

        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(toBinaryString(a));
        System.out.println(toBinaryString(b));
        System.out.println("-----------");
        return  a;
    }

    public static String toBinaryString(int x){
        String s = Integer.toBinaryString(x);
        int length0 = 32 - s.length();
        StringBuilder  pre = new StringBuilder();
        for (int i = 0; i < length0; i++) {
            pre.append("0");
        }
        return pre.toString()+s;
    }

}
