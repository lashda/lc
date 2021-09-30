package no500;

import java.util.Arrays;

/**
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 *
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 *
 * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：machines = [1,0,5]
 * 输出：3
 * 解释：
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 * 示例 2：
 *
 * 输入：machines = [0,3,0]
 * 输出：2
 * 解释：
 * 第一步:    0 <-- 3     0    =>    1     2     0
 * 第二步:    1     2 --> 0    =>    1     1     1
 * 示例 3：
 *
 * 输入：machines = [0,2,0]
 * 输出：-1
 * 解释：
 * 不可能让所有三个洗衣机同时剩下相同数量的衣物。
 *  
 *
 * 提示：
 *
 * n == machines.length
 * 1 <= n <= 104
 * 0 <= machines[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-washing-machines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No517 {
    public static void main(String[] args) {
        //4
        int[] machines = {0,3,0};
        System.out.println(findMinMoves(machines));

    }
    public static int findMinMoves2(int[] machines) {
        int sum = Arrays.stream(machines).sum(), ans = 0, n = machines.length;
        if(sum % n != 0)
            return -1;
        int avg = sum / n;
        int cur = 0;
        for (int machine : machines) {
            System.out.print(machine - avg+",");
        }
        System.out.println();
        for(int machine: machines){
            System.out.print(cur+",");
            int thisAns;
            if(cur < 0 && cur + (machine - avg) > 0){//左通量<0 && 右通量>0 需要分次左右出
                thisAns =  machine - avg; //差值
            } else{
                thisAns = Math.abs(cur); //
            }
            cur += machine - avg;
            ans = Math.max(thisAns,ans);
        }
        System.out.println();
        return ans;
    }

    public static int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        int length = machines.length;
        if(sum % length != 0)
            return -1;
        int avg = sum / length;
        int cur  = 0 ;
        int maxTime = 0;
        int time ;
        for (int i = 0; i < machines.length; i++) {
            int need = avg-machines[i];
            if( cur>0 && need+cur<0){//左cur>0 左边吐  && 右边吐（need<0&&need+cur<0）
                time = Math.abs(need);
            }else{
                time = Math.abs(cur);
            }
            maxTime = Math.max(maxTime,time);
            cur = cur + need;
        }
        return maxTime;
    }

    public static int findMinMovesx(int[] machines) {
        int length = machines.length;
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if(sum==0){
            return 0;
        }
        if(sum%length!=0){
            return -1;
        }
        int avg = sum/length;
        int[] needs = new int[length];


        for (int i = 0; i < machines.length; i++) {
            int machine = machines[i];
            needs[i] = (avg - machine);
        }


        for (int i = 0; i < needs.length; i++) {
            System.out.print(needs[i]+",");
        }
        System.out.println();

        int max = needs[0] ;
        int min = needs[0];
        int maxIndex = 0;
        int minIndex = 0;

        //找到峰值和谷值
        for (int i = 0; i < needs.length; i++) {
            if(max<needs[i]){
                max = needs[i];
                maxIndex = i;
            }
            if(min>needs[i]){
                min = needs[i];
                minIndex = i;
            }
        }

        int handelMaxNum = 0;
        while(max>0){
            if(maxIndex-1>0){
                int left = needs[maxIndex-1];
                if(left<0){
                    max = max + left;
                }
            }
            if(maxIndex+1<needs.length){
                int right = needs[maxIndex+1];
                if(right<0){
                    max = max + right;
                }
            }
            handelMaxNum ++;
        }
        return max;
    }
}
