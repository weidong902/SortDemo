//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2528 👎 0


package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn;

//盛最多水的容器

public class P11_ContainerWithMostWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P11_ContainerWithMostWater().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            //木桶原理:盛放最多水是由最矮的木块决定的.
            //双指针去做,每次找出指针的较小值,算出指针较小值与(左右指针之差)的乘积x,取出最大值与x中的较大值
            //base case
            if (null == height || height.length == 0) return 0;

            int maxA = 0, left = 0, right = height.length - 1;
            while (left < right) {
                if (height[left] > height[right]) {
                    maxA = Math.max(maxA, (right - left) * height[right]);
                    right--;

                } else {
                    maxA = Math.max(maxA, (right - left) * height[left]);
                    left++;
                }
            }
            return maxA;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}