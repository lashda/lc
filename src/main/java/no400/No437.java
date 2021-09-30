package no400;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *  
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,1000]
 * -10^9 <= Node.val <= 10^9 
 * -1000 <= targetSum <= 1000 
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 */
public class No437 {
    public int pathSum(TreeNode root, int targetSum) {
        return match(root,0,targetSum,false);
    }

    /**
     *
     * @param node 当前节点
     * @param accumulation 累积的值
     * @param targetSum 目标值
     * @param addedSelf 是否累加了之上节点
     */
    public int match(TreeNode node, int accumulation, int targetSum, boolean addedSelf){
        if(node==null){
            return 0;
        }
        int count = 0;

        if(node.val+accumulation==targetSum){
            count++;
        }
        //不管之前有没有累加过自己 后续都可以累加
        if(node.left!=null){
            //左边累计 加自己
            count +=match(node.left,accumulation+node.val,targetSum,true);
            //如果之前累加过 后续不能累加
            //只有没累加过的 后续才能不累加
            if(!addedSelf){
                //之前没有累加过自己 才能后续不累加
                //左边累计 不加自己
                count +=match(node.left,accumulation,targetSum,false);
            }
        }
        if(node.right!=null){
            //右边累计 加自己
            count +=match(node.right,accumulation+node.val,targetSum,true);
            //如果之前累加过 后续不能累加
            //只有没累加过的 后续才能不累加
            if(!addedSelf){
                //之前没有累加过自己 才能后续不累加
                //右边累计 不加自己
                count +=match(node.right,accumulation,targetSum,false);
            }
        }
        return  count;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }
}
