//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 695 👎 0


package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn;

//合并两个有序数组

public class P88_MergeSortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P88_MergeSortedArray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 合并两个有序数组
            // 首先需要一个能放下A，B两数组的数组，数组长度为 m+n
            int mIndex = m - 1, nIndex = n - 1;
            for (int mergeIndex = m + n - 1; mIndex >= 0 && nIndex >= 0; mergeIndex--) {
                nums1[mergeIndex] = nums1[mIndex] > nums2[nIndex] ? nums1[mIndex--] : nums2[nIndex--];
            }
            // 如果nums1先结束，将nums2中的元素复制到nums1中。
            //如果nums2先结束则合并结束
            while (nIndex >= 0) {
                nums1[nIndex]=nums2[nIndex--];

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

