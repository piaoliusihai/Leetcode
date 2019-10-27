/*
    Method: Expand Around Center;
    TimeComplexity: O(n ^ 2);
    SpaceComplexity: O(n ^ 2);
    Time: 2019/10/26;
    Attention:
    1. if (s == null || s.length() == 0) return "";
    2. for (int i = s.length() - 1; i >= 0; i--)
    3. for (int j = i; j < s.length(); j++);
*/
class SolutionTwo {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 0, left = 0, right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
