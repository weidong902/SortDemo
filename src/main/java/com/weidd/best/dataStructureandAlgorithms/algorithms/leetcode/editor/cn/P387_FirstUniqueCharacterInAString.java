//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 331 👎 0


package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn;

//字符串中的第一个唯一字符

import java.util.HashMap;
import java.util.Map;

public class P387_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P387_FirstUniqueCharacterInAString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            //暴力破解：双层循环
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            // 第一层循环将字符串中每个字符出现的次数及字符存入到map中
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            //第二层循环查出value=1的字符
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}