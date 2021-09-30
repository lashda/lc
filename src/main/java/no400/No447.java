package no400;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 * 示例 1：
 *
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：points = [[1,1]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 *
 */
public class No447 {

    public static void main(String[] args) {
        int[][] points  = {{0,0},{1,0},{2,0}};
        int i = numberOfBoomerangs(points);
        System.out.println(i);
    }

    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i+1; j < points.length; j++) {
                int[] p2 = points[j];

                int l1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);

                for (int k = j+1; k < points.length; k++) {
                    int[] p3 = points[k];

                    int l2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
                    int l3 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);

                    if(l1==l2){
                        count++;
                        continue;
                    }
                    if(l1==l3){
                        count++;
                        continue;
                    }
                    if(l2==l3){
                        count++;
                    }
                }
            }
        }
        return count*2;
    }
}
