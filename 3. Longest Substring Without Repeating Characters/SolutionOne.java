/*
    Method: Brute Force;
    TimeComplexity: O(n^3);
    SpaceComplexity: O(min(m, n)), m is the length of the string, s is the max length of the hashSet;
    Time: 2019/10/26;
    Attention:
    1. The structure of the code, especially the simplicity function allUnique brings to us.
    2. The boundary of the loop with variable j in lengthOfLongestSubstring and i in allUnique, when to use <= and when to use <;
    3. Set<Character> set = new HashSet<>();
*/
public class SolutionOne {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
