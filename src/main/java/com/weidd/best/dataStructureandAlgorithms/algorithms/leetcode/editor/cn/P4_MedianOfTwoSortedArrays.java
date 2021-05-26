//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4118 👎 0


package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn;

//寻找两个正序数组的中位数

import java.util.ArrayList;

public class P4_MedianOfTwoSortedArrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
		 int[] a ={1,2};
		 int[] b ={3,4};

	 	 double medianSortedArrays = solution.findMedianSortedArrays(a,b);
		 System.out.println(medianSortedArrays);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		// 最简单的想法：可以先合并两个有序数组，然后找出合并后数组的中位数
		if(null==nums1&&null==nums2) return 0;
		ArrayList<Integer> list =new ArrayList<>();
		int n1=0;
		int n2=0;

		while(n1<=nums1.length-1 && n2<=nums2.length-1){
			boolean add=nums1[n1] <= nums2[n2] ? list.add(nums1[n1++]):list.add(nums2[n2++]);
		}
		while (n1<=nums1.length-1){
			list.add(nums1[n1++]);
		}
		while (n2<=nums2.length-1){
			list.add(nums2[n2++]);
		}
		System.out.println(list.toString());
		double res =0.0;
		if(list.size()%2==0){
			res=(double) (list.get(list.size()/2)+list.get(list.size()/2-1))/2;
		}else
			res=list.get(list.size()/2);

		return res;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}