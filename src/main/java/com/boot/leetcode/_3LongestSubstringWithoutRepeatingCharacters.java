package com.boot.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _3LongestSubstringWithoutRepeatingCharacters
 * @Description:
 * @Author: jackson
 * @Date: 2020/7/16 下午2:47
 * @Version: v1.0
 */
public class _3LongestSubstringWithoutRepeatingCharacters {

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    //
    // 示例 1:
    //
    // 输入: "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //
    //
    // 示例 2:
    //
    // 输入: "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //
    //
    // 示例 3:
    //
    // 输入: "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //
    // Related Topics 哈希表 双指针 字符串 Sliding Window

    /**
     *  解决思路为滑动窗口
     *  利用hashset来判断字符是否重复
     *  右指针用于移动窗口的边界
     *  左指针用于删除hashset中判断过的字符
     * @param str
     * @return
     */
    public static Integer longswrc(String str) {
        int length = str.length();
        Set<Character> set = new HashSet<>();
        //初始化最大字符串长度
        int longLength = 0;
        //初始化右指针,指向第一个字符
        int rk = 0;
        for (int i = 0; i < length; i++) {
            //循环时,不断的删除设置的起始点
            if (i != 0) {
                set.remove(str.charAt(i - 1));
            }
            //向hashset中塞入从当前起始点开始的最长不重复字符串
            while (rk < length && !set.contains(str.charAt(rk))) {
                set.add(str.charAt(rk));
                rk++;
            }
            //计算最长不重复字符串长度:
            // rk和左指针中间的间隔即为窗口,也就是最大长度
            longLength = Math.max(longLength,rk - i);
        }
        return longLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        Integer ans = longswrc(str);
        System.out.printf("最大长度:" + ans);
    }
}
