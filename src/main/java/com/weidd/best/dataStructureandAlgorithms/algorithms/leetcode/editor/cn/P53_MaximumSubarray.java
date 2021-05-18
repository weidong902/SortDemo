//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2815 👎 0


package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn;

//最大子序和

public class P53_MaximumSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P53_MaximumSubarray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
			/**
			 *  方式一:暴力求解:穷举法
			 *  当数组为n时,通过穷举法,遍历出所有的子序列为((n+1)*n)/2,
			 *  找出最大和的子序列的时间复杂度为O(n^2),不是最优解.
			 */

			/**
			 * 方式二: 动态规划(dp)
			 * 时间复杂度O(n),空间复杂度O(1)
			 */



            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}