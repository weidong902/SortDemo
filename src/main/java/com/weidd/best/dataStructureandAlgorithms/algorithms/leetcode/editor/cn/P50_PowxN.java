//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 648 👎 0


package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn;

//Pow(x, n)

public class P50_PowxN {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P50_PowxN().new Solution();
        double v = solution.myPow(2, -2);
        System.out.println(v);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0f || x == 1f) return 1;
            int m = 0;
            if (n < 0) {
                m = -n;
                x = 1 / x;
            }else{
            	m=n;
			}
            double sum=1;
            for (int i = 0; i < m; i++) {
                sum = sum * x;
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}