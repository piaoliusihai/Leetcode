/*
    Method: Brute Force;
    TimeComplexity: O(n);
    SpaceComplexity: O(m), m is the size of the charset.;
    Time: 2019/10/26;
    Attention:
    1. int[26] for Letters 'a' - 'z' or 'A' - 'Z';
    2. int[128] for ASCII;
    3. int[256] for Extended ASCII;
    4. index[s.charAt(j)], automatic transformation from Character to Integer.
    5. index[s.charAt(j)] = j + 1; Why there is j + 1 ?
*/
public class SolutionFour {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
