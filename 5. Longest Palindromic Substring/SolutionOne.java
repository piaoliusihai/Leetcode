/*
    Method: Expand Around Center;
    TimeComplexity: O(n ^ 2);
    SpaceComplexity: O(1);
    Time: 2019/10/26;
    Attention:
    1. if (s == null || s.length() < 1) return "";
    2. start = i - (len - 1) / 2;
       end = i + len / 2;
       How to induce this efficiently?
*/
public class SolutionOne {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
