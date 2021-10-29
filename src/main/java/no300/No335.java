package no300;

/**
 * 给你一个整数数组 distance 。
 *
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 *
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：distance = [2,1,1,2]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：distance = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：distance = [1,1,1,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= distance.length <= 105
 * 1 <= distance[i] <= 105
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-crossing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No335 {

    public static void main(String[] args) {
        //[1,2,2,3,4]
        int[] distance = {1,2,2,3,4};
        System.out.println(isSelfCrossing(distance));
    }
    //归纳相交的条件 以此作为条件判断
    public static boolean isSelfCrossing(int[] d) {
        int length = d.length;
        if(length<4){
            return false;
        }
        for (int i = 3; i < length; i++) {
            //如果上一个d<上一个对面的d
            if(d[i]>=d[i-2] && d[i-1]<=d[i-3]){
                //如果当前的d>对面的d || 这条线能和之前这个方向的线接起来
                return true;
            }
            if(i>=4 && d[i-1]==d[i-3]&&d[i]+d[i-4]>=d[i-2]){
                return true;
            }
            if (i >= 5 && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i] + d[i - 4] >= d[i - 2] && d[i - 1] + d[i - 5] >= d[i - 3]) {
                return true;
            }
        }
        return false;
    }

    //归纳不相交的规律 并以此作为条件
    public boolean isSelfCrossing2(int[] distance) {
        int n = distance.length;
        if (n < 4) return false;

        int i = 2;

        // 一直向外卷
        while (i < n && distance[i] > distance[i - 2]) i++;
        // 如果走完了，直接就可以返回不相交
        if (i == n) return false;

        // 如果向外卷转成了向内卷，i-1的长度减i-3的长度
        if (distance[i] >= distance[i - 2] - (i < 4 ? 0 : distance[i - 4])) {
            distance[i - 1] -=  i < 3 ? 0 : distance[i - 3];
        }

        // 一直向内卷，注意i先加1，这样正好跟i-1的位置相比较，相当于内卷从i-1的位置开始的
        for (++i; i < n && distance[i] < distance[i - 2]; i++);

        // 如果 i 能走完就不会相交，相反，走不完就相交了
        return i != n;
    }
}
