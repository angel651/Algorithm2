package 算法挑战;

/**
 * 描述     TODO
 *
 * @author lixinzhen
 * @create 2021/11/6 15:55
 */
//对于给定是字符串s，求出它含不重复的最长子串
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abacuses"));
    }
}

