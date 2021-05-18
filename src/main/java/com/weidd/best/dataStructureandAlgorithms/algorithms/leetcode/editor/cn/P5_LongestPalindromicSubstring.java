//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3649 👎 0


package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn;

//最长回文子串

public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        String str = solution.longestPalindrome("1aba");
        System.out.println(str);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // 特判
            if(null==s || s.length()<2) return s;
            // 中心扩散法
            int res =1; //最大长度
            int ll=0;   //最大回文串的左指针
            int rr=0;   //最大回文串的右指针
            //将字符串转成char数组，不在循环中去使用str.charAt(i)
            char[] chArr =s.toCharArray();

            // 开始遍历char数组
            for(int i =0; i<chArr.length; i++){
                // 以i为中心向两边扩散，寻找最长子串（通俗：回文串为奇数长度i为中心）
                int l =i-1;
                int r =i+1;

                while(l>=0 && r<chArr.length && chArr[l]==chArr[r]){
                    int len =r-l+1;
                    if(len>res){
                        res=len;
                        ll=l;
                        rr=r;
                    }
                    l--;
                    r++;
                }
                // 以i为左指针，i+1为右指针（通俗：回文串为偶数长度）
                l=i;
                r=i+1;
                while(l>=0 && r<chArr.length && chArr[l]==chArr[r]){
                    int len =r-l+1;
                    if(len>res){
                        res=len;
                        ll=l;
                        rr=r;
                    }
                    l--;
                    r++;
                }
            }
            return s.substring(ll,rr+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}